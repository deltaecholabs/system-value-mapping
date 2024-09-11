package com.deltaecholabs.svm.field;

import com.deltaecholabs.svm.api.v1.FieldV1;
import com.deltaecholabs.svm.system.SystemMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = {SystemMapper.class})
public interface FieldMapper {

    FieldV1 toApi(Field domain);

    Field toDomain(FieldV1 api);

    @Mapping(source = "system", target = "system")
    Field toDomain(FieldEntity entity);

}
