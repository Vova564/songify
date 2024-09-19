package org.example.songify.infrastructure.crud.genre.error;

import org.springframework.http.HttpStatus;

public record ErrorGenreResponseDTO(String massage, HttpStatus status) {
}
