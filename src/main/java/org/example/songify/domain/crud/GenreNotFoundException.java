package org.example.songify.domain.crud;

class GenreNotFoundException extends RuntimeException {

    GenreNotFoundException(final String message) {
        super(message);
    }
}
