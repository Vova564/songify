package org.example.songify.domain.crud.dto;

import lombok.Builder;

@Builder
public record GenreDTO(Long id, String name) {
}
