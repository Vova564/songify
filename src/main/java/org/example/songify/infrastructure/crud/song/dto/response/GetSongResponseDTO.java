package org.example.songify.infrastructure.crud.song.dto.response;

import org.example.songify.domain.crud.dto.GenreDTO;

public record GetSongResponseDTO(Long id, String name, GenreDTO genre) {
}
