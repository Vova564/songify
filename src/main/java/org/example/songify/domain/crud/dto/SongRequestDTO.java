package org.example.songify.domain.crud.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public record SongRequestDTO(String name, Instant releaseDate, Long duration, SongLanguageDTO language) {
}
