package org.example.songify.infrastructure.crud.artist.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ArtistNameUpdateRequestDTO(
        @NotNull(message = "Artist name must not be null")
        @NotEmpty(message = "Artist name must not be empty")
        String name) {
}
