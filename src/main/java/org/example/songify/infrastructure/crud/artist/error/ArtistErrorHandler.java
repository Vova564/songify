package org.example.songify.infrastructure.crud.artist.error;

import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.exception.ArtistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
class ArtistErrorHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    public ErrorArtistResponseDTO handleSongNotFoundException(ArtistNotFoundException exception) {
        log.warn("Caught ArtistNotFoundException: {}", exception.getMessage());
        return new ErrorArtistResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
