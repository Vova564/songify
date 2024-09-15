package org.example.songify.infrastructure.crud.genre.dto.response;

import lombok.Builder;

@Builder
public record GenreControllerResponseDTO(Long id, String name) {
}
