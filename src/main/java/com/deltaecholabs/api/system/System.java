package com.deltaecholabs.api.system;

import jakarta.validation.constraints.NotEmpty;

public record System(Integer systemId, @NotEmpty String name) {
}
