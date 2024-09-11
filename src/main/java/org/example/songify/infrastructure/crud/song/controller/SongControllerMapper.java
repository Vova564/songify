package org.example.songify.infrastructure.crud.song.controller;

import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.CreateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.PartiallyUpdateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.request.UpdateSongRequestBodyDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.CreateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.DeleteSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.GetAllSongsResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.GetSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.PartiallyUpdateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.SongControllerResponseDTO;
import org.example.songify.infrastructure.crud.song.controller.dto.response.UpdateSongResponseDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class SongControllerMapper {

    public static SongDTO mapFromCreateSongRequestDTOToSongDTO(CreateSongRequestBodyDTO dto) {
        return SongDTO.builder()
                .song(dto.song())
                .build();
    }

    public static SongDTO mapFromUpdateSongRequestBodyDTOToSongDTO(UpdateSongRequestBodyDTO dto) {
        return SongDTO.builder()
                .song(dto.song())
                .build();
    }

    public static SongDTO mapFromPartiallyUpdateSongRequestBodyDTOToSongDTO(PartiallyUpdateSongRequestBodyDTO dto) {
        return SongDTO.builder()
                .song(dto.song())
                .build();
    }

    static SongControllerResponseDTO mapFromSongDTOToSongControllerResponseDTO(SongDTO entity) {
        return SongControllerResponseDTO.builder()
                .id(entity.id())
                .song(entity.song())
                .build();
    }

    static GetAllSongsResponseDTO mapFromSongDTOToGetAllSongsResponseDTO(List<SongDTO> songs) {
        List<SongControllerResponseDTO> songControllerResponseDTOs = songs.stream()
                .map(SongControllerMapper::mapFromSongDTOToSongControllerResponseDTO)
                .toList();
        return new GetAllSongsResponseDTO(songControllerResponseDTOs);
    }

    static GetSongResponseDTO mapFromSongToGetSongResponseDTO(SongDTO entity) {
        SongControllerResponseDTO songControllerResponseDTO = mapFromSongDTOToSongControllerResponseDTO(entity);
        return new GetSongResponseDTO(songControllerResponseDTO);
    }

    static CreateSongResponseDTO mapFromSongToCreateSongResponseDTO(SongDTO entity) {
        SongControllerResponseDTO songControllerResponseDTO = mapFromSongDTOToSongControllerResponseDTO(entity);
        return new CreateSongResponseDTO(songControllerResponseDTO);
    }

    static DeleteSongResponseDTO mapFromSongDTOToDeleteSongResponseDTO(Long id) {
        return new DeleteSongResponseDTO("You deleted song with id " + id, HttpStatus.OK);
    }

    static UpdateSongResponseDTO mapFromSongDTOToUpdateSongResponseDTO(SongDTO entity) {
        SongControllerResponseDTO songControllerResponseDTO = mapFromSongDTOToSongControllerResponseDTO(entity);
        return new UpdateSongResponseDTO(songControllerResponseDTO);
    }

    static PartiallyUpdateSongResponseDTO mapFromSongDTOToPartiallyUpdateSongResponseDTO(SongDTO entity) {
        SongControllerResponseDTO songControllerResponseDTO = mapFromSongDTOToSongControllerResponseDTO(entity);
        return new PartiallyUpdateSongResponseDTO(songControllerResponseDTO);
    }

}
