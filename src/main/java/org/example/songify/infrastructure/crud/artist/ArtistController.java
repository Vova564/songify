package org.example.songify.infrastructure.crud.artist;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.infrastructure.crud.artist.dto.CreateArtistResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.GetAllArtistsResponseDTO;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/artists")
public class ArtistController {

    private final SongifyCrudFacade songifyCrudFacade;
    private final ArtistControllerMapper mapper;

    @GetMapping
    ResponseEntity<GetAllArtistsResponseDTO> findAllArtists(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Set<ArtistDTO> artistDTOS = songifyCrudFacade.findAllArtists(pageable);

        GetAllArtistsResponseDTO response = mapper.mapFromArtistDTOToGetAllArtistsResponseDTO(artistDTOS);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<CreateArtistResponseDTO> addArtist(@RequestBody ArtistRequestDTO requestBody) {
        ArtistDTO savedArtist = songifyCrudFacade.addArtist(requestBody);

        CreateArtistResponseDTO response = mapper.mapFromArtistDTOToCreateArtistResponseDTO(savedArtist);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteArtistResponseDTO> deleteArtistWithAllAlbumsAndSongs(@PathVariable Long id) {
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(id);

        DeleteArtistResponseDTO response = new DeleteArtistResponseDTO("Deleted artist with id " + id);
        return ResponseEntity.ok(response);
    }


}
