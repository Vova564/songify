package org.example.songify.infrastructure.crud.song.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.song.SongCrudFacade;
import org.example.songify.domain.crud.song.dto.SongDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.CreateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.PartiallyUpdateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.UpdateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.CreateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.DeleteSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.GetAllSongsResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.GetSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.PartiallyUpdateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.UpdateSongResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromCreateSongRequestDTOToSongDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromPartiallyUpdateSongRequestBodyDTOToSongDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongDTOToDeleteSongResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongDTOToGetAllSongsResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongDTOToPartiallyUpdateSongResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongDTOToUpdateSongResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongToCreateSongResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromSongToGetSongResponseDTO;
import static org.example.songify.infrastructure.crud.song.controller.SongControllerMapper.mapFromUpdateSongRequestBodyDTOToSongDTO;

@RestController
@Log4j2
@RequestMapping("/songs")
@AllArgsConstructor
public class SongRestController {

    private final SongCrudFacade songCrudFacade;

    @GetMapping
    public ResponseEntity<GetAllSongsResponseDTO> getAllSongs(@PageableDefault Pageable pageable) {
        List<SongDTO> allSongDTOs = songCrudFacade.findAll(pageable);
        GetAllSongsResponseDTO response = mapFromSongDTOToGetAllSongsResponseDTO(allSongDTOs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSongResponseDTO> getSongById(@PathVariable Long id, @RequestHeader(required = false) String requestId) {
        if (requestId != null) {
            log.info(requestId);
        }

        SongDTO songDTO = songCrudFacade.findSongById(id);

        GetSongResponseDTO response = mapFromSongToGetSongResponseDTO(songDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateSongResponseDTO> postSong(@Valid @RequestBody CreateSongRequestBodyDTO requestBody) {
        SongDTO songDTO = mapFromCreateSongRequestDTOToSongDTO(requestBody);
        SongDTO savedSong = songCrudFacade.addSong(songDTO);

        CreateSongResponseDTO response = mapFromSongToCreateSongResponseDTO(savedSong);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSongResponseDTO> deleteSongByIdUsingPathVariable(@PathVariable Long id) {
        songCrudFacade.deleteById(id);

        DeleteSongResponseDTO response = mapFromSongDTOToDeleteSongResponseDTO(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSongResponseDTO> updateSong(@PathVariable Long id, @Valid @RequestBody UpdateSongRequestBodyDTO requestBody) {
        SongDTO song = mapFromUpdateSongRequestBodyDTOToSongDTO(requestBody);
        songCrudFacade.updateById(id, song);

        UpdateSongResponseDTO response = mapFromSongDTOToUpdateSongResponseDTO(song);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PartiallyUpdateSongResponseDTO> partiallyUpdateSong(@PathVariable Long id, @RequestBody PartiallyUpdateSongRequestBodyDTO requestBody) {
        SongDTO songToUpdate = mapFromPartiallyUpdateSongRequestBodyDTOToSongDTO(requestBody);
        SongDTO updatedSong = songCrudFacade.updatePartiallyById(id, songToUpdate);

        PartiallyUpdateSongResponseDTO response = mapFromSongDTOToPartiallyUpdateSongResponseDTO(updatedSong);
        return ResponseEntity.ok(response);
    }
}
