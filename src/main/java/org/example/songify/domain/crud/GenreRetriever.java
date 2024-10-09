package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.exception.GenreNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class GenreRetriever {

    private final GenreRepository genreRepository;
    private final SongifyDomainMapper mapper;

    Set<GenreDTO> findAllGenres() {
        Set<Genre> genres = genreRepository.findAll();
        return genres.stream()
                .map(mapper::mapFromGenreToGenreDTO)
                .collect(Collectors.toSet());
    }

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
