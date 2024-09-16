package org.example.songify.infrastructure.crud.song.error;

import org.springframework.http.HttpStatus;

public record ErrorSongResponseDTO(String massage, HttpStatus status) {
}
