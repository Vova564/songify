package org.example.songify.infrastructure.crud.song.controller.dto.response;

import lombok.Builder;

@Builder
public record SongControllerResponseDTO(Long id, String artist, String song) {
}
