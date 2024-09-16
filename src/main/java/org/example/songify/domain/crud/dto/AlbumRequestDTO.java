package org.example.songify.domain.crud.dto;

import java.time.Instant;

public record AlbumRequestDTO(String name, Instant releaseDate, Long songId) {
}
