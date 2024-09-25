package org.example.songify.domain.crud.exception;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(final Long id) {
        super("Song with id " + id + " not found");
    }
}
