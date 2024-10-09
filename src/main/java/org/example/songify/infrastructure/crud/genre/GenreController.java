package org.example.songify.infrastructure.crud.genre;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.example.songify.infrastructure.crud.genre.dto.CreateGenreResponseDTO;
import org.example.songify.infrastructure.crud.genre.dto.GetAllGenresResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/genres")
public class GenreController {

    private final SongifyCrudFacade songifyCrudFacade;
    private final GenreControllerMapper mapper;

    @GetMapping
    ResponseEntity<GetAllGenresResponseDTO> findAllGenres() {
        Set<GenreDTO> genres = songifyCrudFacade.findAllGenres();

        GetAllGenresResponseDTO response = mapper.mapFromGenreDTOToGetAllGenresResponseDTO(genres);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<CreateGenreResponseDTO> addGenre(@RequestBody GenreRequestDTO requestBody) {
        GenreDTO savedGenre = songifyCrudFacade.addGenre(requestBody);

        CreateGenreResponseDTO response = mapper.mapFromGenreDTOToCreateGenreResponseDTO(savedGenre);
        return ResponseEntity.ok(response);
    }
}
