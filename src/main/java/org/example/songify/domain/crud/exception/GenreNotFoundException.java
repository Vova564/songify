package org.example.songify.domain.crud.exception;

public class GenreNotFoundException extends RuntimeException {

    public GenreNotFoundException(final Long id) {
        super("Genre with id " + id + " not found");
    }
}
