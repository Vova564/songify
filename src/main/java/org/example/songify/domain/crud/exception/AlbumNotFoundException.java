package org.example.songify.domain.crud.exception;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(final Long id) {
        super("Album with id " + id + " not found");
    }
}
