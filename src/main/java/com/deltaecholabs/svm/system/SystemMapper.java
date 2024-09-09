package com.deltaecholabs.svm.system;

import com.deltaecholabs.svm.api.v1.SystemV1;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface SystemMapper {

    SystemV1 toApi(System system);

    System toDomain(SystemV1 system);

    System toDomain(SystemEntity entity);

}
