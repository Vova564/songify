package org.example.songify.infrastructure.crud.artist;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.infrastructure.crud.artist.dto.CreateArtistResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.GetAllArtistsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/artist")
public class ArtistController {

    private final SongifyCrudFacade songifyCrudFacade;
    private final ArtistControllerMapper mapper;

    @GetMapping
    ResponseEntity<GetAllArtistsResponseDTO> findAll() {
        Set<ArtistDTO> artistDTOS = songifyCrudFacade.findAllArtists();

        GetAllArtistsResponseDTO response = mapper.mapFromArtistDTOToGetAllArtistsResponseDTO(artistDTOS);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<CreateArtistResponseDTO> addArtist(@RequestBody ArtistRequestDTO requestBody) {
        ArtistDTO savedArtist = songifyCrudFacade.addArtist(requestBody);

        CreateArtistResponseDTO response = mapper.mapFromArtistDTOToCreateArtistResponseDTO(savedArtist);
        return ResponseEntity.ok(response);
    }


}
