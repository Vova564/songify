package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.exception.GenreNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class GenreRetriever {

    private final GenreRepository genreRepository;

    void genreExistsById(final Long id) {
        if (!genreRepository.existsById(id)) {
            throw new GenreNotFoundException("Genre with id " + id + " not found");
        }
    }
}
