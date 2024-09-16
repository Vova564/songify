package org.example.songify.infrastructure.crud.genre;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.example.songify.infrastructure.crud.genre.dto.CreateGenreResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.songify.infrastructure.crud.genre.GenreControllerMapper.mapFromGenreDTOToCreateGenreResponseDTO;

@RestController
@AllArgsConstructor
@RequestMapping("/genre")
public class GenreController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping
    ResponseEntity<CreateGenreResponseDTO> addGenre(@RequestBody GenreRequestDTO requestBody) {
        GenreDTO savedGenre = songifyCrudFacade.addGenre(requestBody);

        CreateGenreResponseDTO response = mapFromGenreDTOToCreateGenreResponseDTO(savedGenre);
        return ResponseEntity.ok(response);
    }
}
