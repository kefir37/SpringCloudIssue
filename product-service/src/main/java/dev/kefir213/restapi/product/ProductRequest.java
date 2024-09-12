package dev.kefir213.restapi.product;


import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductRequest(
        UUID id,
        @NotNull(message = "title is required")
        String title,
        @NotNull(message = "title is required")
        String description
) {
}
