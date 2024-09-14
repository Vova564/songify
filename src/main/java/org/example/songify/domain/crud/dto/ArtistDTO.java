package org.example.songify.domain.crud.dto;

import lombok.Builder;

@Builder
public record ArtistDTO(Long id, String name) {
}
