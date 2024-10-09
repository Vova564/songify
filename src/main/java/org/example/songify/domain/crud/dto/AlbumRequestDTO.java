package org.example.songify.domain.crud.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.Set;

@Builder
public record AlbumRequestDTO(String name, Instant releaseDate, Set<Long> songIds) {
}
