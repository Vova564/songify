package org.example.songify.infrastructure.crud.song;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.songify.domain.crud.SongifyCrudFacade;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.example.songify.infrastructure.crud.song.dto.response.CreateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.DeleteSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.GetAllSongsResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.GetSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.PartiallyUpdateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.UpdateSongResponseDTO;
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

@RestController
@Log4j2
@RequestMapping("/songs")
@AllArgsConstructor
public class SongRestController {

    private final SongifyCrudFacade songifyCrudFacade;
    private final SongControllerMapper mapper;

    @GetMapping
    public ResponseEntity<GetAllSongsResponseDTO> getAllSongs(@PageableDefault Pageable pageable) {
        List<SongDTO> allSongDTOs = songifyCrudFacade.findAllSongs(pageable);
        GetAllSongsResponseDTO response = mapper.mapFromSongDTOToGetAllSongsResponseDTO(allSongDTOs);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSongResponseDTO> getSongById(@PathVariable Long id, @RequestHeader(required = false) String requestId) {
        if (requestId != null) {
            log.info(requestId);
        }

        SongDTO songDTO = songifyCrudFacade.findSongById(id);

        GetSongResponseDTO response = mapper.mapFromSongToGetSongResponseDTO(songDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateSongResponseDTO> postSong(@Valid @RequestBody SongRequestDTO requestBody) {
        SongDTO addedSong = songifyCrudFacade.addSong(requestBody);

        CreateSongResponseDTO response = mapper.mapFromSongToCreateSongResponseDTO(addedSong);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteSongResponseDTO> deleteSongByIdUsingPathVariable(@PathVariable Long id) {
        songifyCrudFacade.deleteSongById(id);

        DeleteSongResponseDTO response = new DeleteSongResponseDTO("Deleted song with id " + id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateSongResponseDTO> updateSong(@PathVariable Long id, @Valid @RequestBody SongRequestDTO requestBody) {
        songifyCrudFacade.updateSongById(id, requestBody);

        UpdateSongResponseDTO response = new UpdateSongResponseDTO("Updated song with id " + id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PartiallyUpdateSongResponseDTO> partiallyUpdateSong(@PathVariable Long id, @RequestBody SongRequestDTO requestBody) {
        SongDTO updatedSong = songifyCrudFacade.updateSongPartiallyById(id, requestBody);

        PartiallyUpdateSongResponseDTO response = mapper.mapFromSongDTOToPartiallyUpdateSongResponseDTO(updatedSong);
        return ResponseEntity.ok(response);
    }
}
