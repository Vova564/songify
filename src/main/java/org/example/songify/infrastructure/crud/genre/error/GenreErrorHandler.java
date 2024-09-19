package org.example.songify.infrastructure.crud.genre.error;

import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.exception.GenreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GenreErrorHandler {

    @ExceptionHandler(GenreNotFoundException.class)
    public ErrorGenreResponseDTO handleSongNotFoundException(GenreNotFoundException exception) {
        log.warn("Caught GenreNotFoundException: {}", exception.getMessage());
        return new ErrorGenreResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
