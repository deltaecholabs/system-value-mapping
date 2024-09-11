package com.deltaecholabs.svm.api.v1;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FieldV1(
        @NotNull(message = "{Field.system.required}")
        SystemV1 system,
        @NotEmpty(message = "{Field.name.required}")
        String name,
        String description) {
}
