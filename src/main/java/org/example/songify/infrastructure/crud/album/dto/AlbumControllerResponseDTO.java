package org.example.songify.infrastructure.crud.album.dto;

import lombok.Builder;

@Builder
public record AlbumControllerResponseDTO(Long id, String name) {
}
