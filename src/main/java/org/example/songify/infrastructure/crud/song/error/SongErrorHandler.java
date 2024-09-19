package org.example.songify.infrastructure.crud.song.error;

import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.exception.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class SongErrorHandler {

    @ExceptionHandler(SongNotFoundException.class)
    public ErrorSongResponseDTO handleSongNotFoundException(SongNotFoundException exception) {
        log.warn("Caught SongNotFoundException: {}", exception.getMessage());
        return new ErrorSongResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
