package org.example.songify.domain.crud.exception;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(final Long id) {
        super("Artist with id " + id + " not found");
    }
}
