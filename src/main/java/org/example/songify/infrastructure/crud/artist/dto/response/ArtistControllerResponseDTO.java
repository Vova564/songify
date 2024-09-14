package org.example.songify.infrastructure.crud.artist.dto.response;

import lombok.Builder;

@Builder
public record ArtistControllerResponseDTO(Long id, String name) {
}
