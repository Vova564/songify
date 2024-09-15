package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class GenreAdder {

    private final GenreRepository genreRepository;

    Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}
