package org.example.songify.infrastructure.crud.genre.dto;

import java.util.Set;

public record GetAllGenresResponseDTO(Set<GenreControllerResponseDTO> genres) {
}
