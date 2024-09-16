package org.example.songify.infrastructure.crud.song.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSongRequestBodyDTO(
        @NotNull(message = "name must not be null")
        @NotEmpty(message = "name must not be empty")
        String artist,

        @NotNull(message = "artist must not be null")
        @NotEmpty(message = "artist must not be empty")
        String name
) { }
