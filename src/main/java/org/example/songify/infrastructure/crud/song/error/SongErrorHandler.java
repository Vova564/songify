package org.example.songify.infrastructure.crud.song.error;

import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class SongErrorHandler {

    @ExceptionHandler(SongNotFoundException.class)
    @ResponseBody
    @ResponseStatus
    public ErrorSongResponseDTO handleSongNotFoundException(SongNotFoundException exception) {
        log.warn("Error while accessing name: {}", exception.getMessage());
        return new ErrorSongResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
