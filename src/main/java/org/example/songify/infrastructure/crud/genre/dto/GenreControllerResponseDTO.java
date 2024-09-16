package org.example.songify.infrastructure.crud.genre.dto;

import lombok.Builder;

@Builder
public record GenreControllerResponseDTO(Long id, String name) {
}
