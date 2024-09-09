package org.example.songify.infrastructure.crud.song.controller.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteSongResponseDTO(String massage, HttpStatus status) {
}
