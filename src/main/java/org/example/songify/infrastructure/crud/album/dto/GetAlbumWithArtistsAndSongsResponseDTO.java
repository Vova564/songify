package org.example.songify.infrastructure.crud.album.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record GetAlbumWithArtistsAndSongsResponseDTO(AlbumControllerResponseDTO album, Set<String> artists, Set<String> songs) {
}
