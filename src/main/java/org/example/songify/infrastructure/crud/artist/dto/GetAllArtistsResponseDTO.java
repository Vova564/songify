package org.example.songify.infrastructure.crud.artist.dto;

import java.util.Set;

public record GetAllArtistsResponseDTO(Set<ArtistControllerResponseDTO> artists) {
}
