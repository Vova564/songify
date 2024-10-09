package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.exception.GenreNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class GenreRetriever {

    private final GenreRepository genreRepository;

    Genre getGenreByIdFromDb(final Long id) {
        return  genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
    }

    void genreExistsById(final Long id) {
        if (!genreRepository.existsById(id)) {
            throw new GenreNotFoundException(id);
        }
    }
}
