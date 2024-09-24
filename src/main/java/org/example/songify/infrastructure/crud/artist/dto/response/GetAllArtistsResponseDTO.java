package org.example.songify.infrastructure.crud.artist.dto.response;

import java.util.Set;

public record GetAllArtistsResponseDTO(Set<ArtistControllerResponseDTO> artists) {
}
