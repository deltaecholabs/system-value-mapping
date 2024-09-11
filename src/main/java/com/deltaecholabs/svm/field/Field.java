package com.deltaecholabs.svm.field;

import com.deltaecholabs.svm.system.System;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record Field(
        @NotNull(message = "{Field.system.required}")
        System system,
        @NotEmpty(message = "{Field.name.required}")
        String name,
        String description) {
}
