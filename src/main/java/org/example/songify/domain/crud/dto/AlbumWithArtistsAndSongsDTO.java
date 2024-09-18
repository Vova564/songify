package org.example.songify.domain.crud.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record AlbumWithArtistsAndSongsDTO(AlbumDTO album, Set<ArtistDTO> artists, Set<SongDTO> songs) {
}
