package org.example.songify.infrastructure.crud.artist.dto;

import lombok.Builder;

@Builder
public record ArtistControllerResponseDTO(Long id, String name) {
}
