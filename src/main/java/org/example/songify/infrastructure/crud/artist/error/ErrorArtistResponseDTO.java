package org.example.songify.infrastructure.crud.artist.error;

import org.springframework.http.HttpStatus;

public record ErrorArtistResponseDTO(String message, HttpStatus httpStatus) {
}
