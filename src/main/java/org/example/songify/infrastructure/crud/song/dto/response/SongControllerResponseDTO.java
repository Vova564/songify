package org.example.songify.infrastructure.crud.song.dto.response;

import lombok.Builder;

@Builder
public record SongControllerResponseDTO(Long id, String name) {
}
