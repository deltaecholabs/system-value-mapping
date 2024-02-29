package com.deltaecholabs.api.system;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface SystemMapper {
    
    System toDomain(SystemEntity entity);
    
    SystemEntity toEntity(System customer);
    
}