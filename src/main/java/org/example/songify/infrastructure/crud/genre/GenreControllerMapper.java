package org.example.songify.infrastructure.crud.genre;

import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.infrastructure.crud.genre.dto.response.CreateGenreResponseDTO;
import org.example.songify.infrastructure.crud.genre.dto.response.GenreControllerResponseDTO;

class GenreControllerMapper {

    static GenreControllerResponseDTO mapFromGenreDTOToGenreControllerResponseDTO(GenreDTO entity) {
        return GenreControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    static CreateGenreResponseDTO mapFromGenreDTOToCreateGenreResponseDTO(GenreDTO entity) {
        GenreControllerResponseDTO genreControllerResponseDTO = mapFromGenreDTOToGenreControllerResponseDTO(entity);
        return new CreateGenreResponseDTO(genreControllerResponseDTO);
    }
}
