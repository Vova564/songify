package org.example.songify.infrastructure.crud.album.error;

import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.exception.AlbumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class AlbumErrorHandler {

    @ExceptionHandler(AlbumNotFoundException.class)
    public ErrorAlbumResponseDTO handleSongNotFoundException(AlbumNotFoundException exception) {
        log.warn("Caught AlbumNotFoundException: {}", exception.getMessage());
        return new ErrorAlbumResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
