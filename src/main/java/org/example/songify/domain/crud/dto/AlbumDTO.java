package org.example.songify.domain.crud.dto;

import lombok.Builder;

@Builder
public record AlbumDTO(Long id, String name) {
}
