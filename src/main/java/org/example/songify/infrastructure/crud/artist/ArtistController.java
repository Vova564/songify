package org.example.songify.infrastructure.crud.artist;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.infrastructure.crud.artist.dto.request.CreateArtistRequestBodyDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.CreateArtistResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.songify.infrastructure.crud.artist.ArtistControllerMapper.mapFromArtistDTOToCreateArtistResponseDTO;
import static org.example.songify.infrastructure.crud.artist.ArtistControllerMapper.mapFromCreateArtistRequestBodyDTOToArtistDTO;


@RestController
@AllArgsConstructor
@RequestMapping("/artist")
public class ArtistController {
    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping
    ResponseEntity<CreateArtistResponseDTO> addArtist(@RequestBody CreateArtistRequestBodyDTO requestBody) {
        ArtistDTO artistDTO = mapFromCreateArtistRequestBodyDTOToArtistDTO(requestBody);
        ArtistDTO savedArtist = songifyCrudFacade.addArtist(artistDTO);

        CreateArtistResponseDTO response = mapFromArtistDTOToCreateArtistResponseDTO(savedArtist);
        return ResponseEntity.ok(response);
    }


}
