package org.example.songify.infrastructure.crud.artist;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.infrastructure.crud.artist.dto.request.ArtistNameUpdateRequestDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.CreateArtistResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.DeleteArtistResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.GetAllArtistsResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.UpdateArtistNameResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.UpdateArtistResponseDTO;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("album/song")
    ResponseEntity<CreateArtistResponseDTO> addArtistWithDefaultAlbumAndSong(@RequestBody ArtistRequestDTO requestBody) {
        ArtistDTO savedArtist = songifyCrudFacade.addArtistWithDefaultAlbumAndSong(requestBody);

        CreateArtistResponseDTO response = mapper.mapFromArtistDTOToCreateArtistResponseDTO(savedArtist);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteArtistResponseDTO> deleteArtistWithAllAlbumsAndSongs(@PathVariable Long id) {
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(id);

        DeleteArtistResponseDTO response = new DeleteArtistResponseDTO("Deleted artist with id " + id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{artistId}/{albumId}")
    ResponseEntity<UpdateArtistResponseDTO> addArtistToAlbum(@PathVariable Long artistId, @PathVariable Long albumId) {
        songifyCrudFacade.addArtistToAlbum(artistId, albumId);

        UpdateArtistResponseDTO response = new UpdateArtistResponseDTO("Artist with id " + artistId + " was assigned to album with id " + albumId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    ResponseEntity<UpdateArtistNameResponseDTO> updateArtistNameById(@PathVariable Long id, @Valid @RequestBody ArtistNameUpdateRequestDTO requestBody) {
        songifyCrudFacade.updateArtistNameById(id, requestBody.name());

        UpdateArtistNameResponseDTO response = new UpdateArtistNameResponseDTO("Artist with id " + id + " changed name to " + requestBody.name());
        return ResponseEntity.ok(response);
    }
}
