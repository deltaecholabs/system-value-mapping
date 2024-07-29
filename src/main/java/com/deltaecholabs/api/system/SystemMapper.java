package com.deltaecholabs.api.system;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface SystemMapper {
    
    System toDomain(SystemEntity entity);
    
    SystemEntity toEntity(System customer);

    void updateEntity(System system, @MappingTarget SystemEntity entity);
    
}