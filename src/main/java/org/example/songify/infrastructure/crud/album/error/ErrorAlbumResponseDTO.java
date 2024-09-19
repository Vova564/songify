package org.example.songify.infrastructure.crud.album.error;

import org.springframework.http.HttpStatus;

public record ErrorAlbumResponseDTO(String massage, HttpStatus status) {
}
