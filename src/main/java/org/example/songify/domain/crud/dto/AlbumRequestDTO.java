package org.example.songify.domain.crud.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public record AlbumRequestDTO(String name, Instant releaseDate, Long songId) {
}
