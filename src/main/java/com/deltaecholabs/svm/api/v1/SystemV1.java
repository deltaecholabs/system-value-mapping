package com.deltaecholabs.svm.api.v1;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record SystemV1(
        @NotBlank(message = "{System.name.required}")
        @Schema(example = "system-name")
        String name,
        @NotBlank(message = "{System.description.required}")
        @Schema(example = "This is a description about a system")
        String description
) {
}
