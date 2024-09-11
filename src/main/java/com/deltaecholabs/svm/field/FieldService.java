package com.deltaecholabs.svm.field;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class FieldService {

    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    public FieldService(FieldRepository fieldRepository, FieldMapper fieldMapper) {
        this.fieldRepository = fieldRepository;
        this.fieldMapper = fieldMapper;
    }

    public List<Field> findAll() {
        return fieldRepository.findAll().stream().map(fieldMapper::toDomain).toList();
    }

}
