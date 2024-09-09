package com.deltaecholabs.svm.system;

import jakarta.validation.constraints.NotBlank;

public record System(
        @NotBlank(message = "{System.name.required}") String name,
        @NotBlank(message = "{System.description.required}") String description
) {
}
