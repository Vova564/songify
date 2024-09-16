package org.example.songify.infrastructure.crud.album;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.infrastructure.crud.album.dto.CreateAlbumResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.songify.infrastructure.crud.album.AlbumContorllerMapper.mapFromAlbumDTOToCreateAlbumResponseDTO;


@RestController
@AllArgsConstructor
@RequestMapping("/album")
public class AlbumController {
    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping
    ResponseEntity<CreateAlbumResponseDTO> addAlbum(@RequestBody AlbumRequestDTO requestBody) {
        AlbumDTO savedAlbum = songifyCrudFacade.addAlbum(requestBody);

        CreateAlbumResponseDTO response = mapFromAlbumDTOToCreateAlbumResponseDTO(savedAlbum);
        return ResponseEntity.ok(response);
    }


}
