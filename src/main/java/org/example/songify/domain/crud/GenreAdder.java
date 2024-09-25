package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class GenreAdder {

    private final GenreRepository genreRepository;
    private final SongifyDomainMapper mapper;

    GenreDTO addGenre(final GenreRequestDTO genreRequestDTO) {
        Genre genre = mapper.mapFromGenreRequestDTOToGenre(genreRequestDTO);
        Genre addedGenre = genreRepository.save(genre);
        return mapper.mapFromGenreToGenreDTO(addedGenre);
    }
}
