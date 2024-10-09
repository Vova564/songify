package org.example.songify.infrastructure.crud.genre;

import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.infrastructure.crud.genre.dto.CreateGenreResponseDTO;
import org.example.songify.infrastructure.crud.genre.dto.GenreControllerResponseDTO;
import org.example.songify.infrastructure.crud.genre.dto.GetAllGenresResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
class GenreControllerMapper {

    GenreControllerResponseDTO mapFromGenreDTOToGenreControllerResponseDTO(GenreDTO entity) {
        return GenreControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    GetAllGenresResponseDTO mapFromGenreDTOToGetAllGenresResponseDTO(Set<GenreDTO> entities) {
        Set<GenreControllerResponseDTO> genresControllerResponseDTOs = entities.stream()
                .map(this::mapFromGenreDTOToGenreControllerResponseDTO)
                .collect(Collectors.toSet());
        return new GetAllGenresResponseDTO(genresControllerResponseDTOs);
    }

    CreateGenreResponseDTO mapFromGenreDTOToCreateGenreResponseDTO(GenreDTO entity) {
        GenreControllerResponseDTO genreControllerResponseDTO = mapFromGenreDTOToGenreControllerResponseDTO(entity);
        return new CreateGenreResponseDTO(genreControllerResponseDTO);
    }
}
