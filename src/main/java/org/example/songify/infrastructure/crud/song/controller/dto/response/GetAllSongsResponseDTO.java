package org.example.songify.infrastructure.crud.song.controller.dto.response;

import java.util.List;

public record GetAllSongsResponseDTO(List<SongControllerResponseDTO> songs) {
}
