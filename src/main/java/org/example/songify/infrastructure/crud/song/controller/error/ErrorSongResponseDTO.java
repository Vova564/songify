package org.example.songify.infrastructure.crud.song.controller.error;

import org.springframework.http.HttpStatus;

public record ErrorSongResponseDTO(String massage, HttpStatus status) {
}
