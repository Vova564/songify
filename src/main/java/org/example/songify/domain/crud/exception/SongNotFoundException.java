package org.example.songify.domain.crud.exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(final String message) {
        super(message);
    }
}
