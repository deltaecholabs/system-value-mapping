package com.deltaecholabs.svm.api.v1;

import jakarta.validation.constraints.NotBlank;

public record SystemV1(
        @NotBlank(message = "{System.name.required}") String name,
        @NotBlank(message = "{System.description.required}") String description
) {
}
