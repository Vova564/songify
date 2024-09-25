package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class GenreDeleter {
    private final GenreRepository genreRepository;
    private final GenreRetriever genreRetriever;

    void deleteById(final Long id) {
        genreRetriever.genreExistsById(id);
        genreRepository.deleteById(id);
    }
}
