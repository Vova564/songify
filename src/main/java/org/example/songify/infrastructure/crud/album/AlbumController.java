package org.example.songify.infrastructure.crud.album;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.domain.crud.dto.AlbumWithArtistsAndSongsDTO;
import org.example.songify.infrastructure.crud.album.dto.CreateAlbumResponseDTO;
import org.example.songify.infrastructure.crud.album.dto.GetAlbumWithArtistsAndSongsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/albums")
public class AlbumController {
    private final SongifyCrudFacade songifyCrudFacade;
    private final AlbumControllerMapper mapper;

    @GetMapping("/{id}")
    ResponseEntity<GetAlbumWithArtistsAndSongsResponseDTO> findAlbumByIdWithArtistsAndSongs(@PathVariable Long id) {
        AlbumWithArtistsAndSongsDTO album = songifyCrudFacade.findAlbumByIdWithArtistsAndSongs(id);

        GetAlbumWithArtistsAndSongsResponseDTO response = mapper.mapFromAlbumWithArtistsAndSongsDTOToGetAlbumWithArtistsAndSongsResponseDTO(album);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<CreateAlbumResponseDTO> addAlbum(@RequestBody AlbumRequestDTO requestBody) {
        AlbumDTO savedAlbum = songifyCrudFacade.addAlbumWithSong(requestBody);

        CreateAlbumResponseDTO response = mapper.mapFromAlbumDTOToCreateAlbumResponseDTO(savedAlbum);
        return ResponseEntity.ok(response);
    }


}
