package com.deltaecholabs.api.system;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class SystemService {

    private final SystemRepository systemRepository;
    private final SystemMapper systemMapper;

    public SystemService(SystemRepository systemRepository, SystemMapper systemMapper) {
        this.systemRepository = systemRepository;
        this.systemMapper = systemMapper;
    }

    public List<System> findAll() {
        return this.systemRepository.findAll().stream()
                .map(systemMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Optional<System> findById(int systemId) {
        return this.systemRepository.findByIdOptional(systemId)
                .map(systemMapper::toDomain);
    }

    @Transactional
    public System create(@Valid System system) {
        SystemEntity entity = this.systemMapper.toEntity(system);
        this.systemRepository.persist(entity);
        return this.systemMapper.toDomain(entity);
    }

    @Transactional
    public System update(@Valid System system) {
        SystemEntity entity = this.systemRepository.findById(system.systemId());
        entity.name = system.name();
        this.systemRepository.persist(entity);
        return this.systemMapper.toDomain(entity);
    }

    @Transactional
    public void delete(int systemId) {
        this.systemRepository.deleteById(systemId);
    }

}