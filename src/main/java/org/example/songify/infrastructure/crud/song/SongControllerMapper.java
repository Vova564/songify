package org.example.songify.infrastructure.crud.song;

import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.infrastructure.crud.song.dto.response.CreateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.GetAllSongsResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.GetSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.PartiallyUpdateSongResponseDTO;
import org.example.songify.infrastructure.crud.song.dto.response.SongControllerResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class SongControllerMapper {

    SongControllerResponseDTO mapFromSongDTOToSongControllerResponseDTO(SongDTO entity) {
        return SongControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    GetAllSongsResponseDTO mapFromSongDTOToGetAllSongsResponseDTO(List<SongDTO> songs) {
        List<SongControllerResponseDTO> songControllerResponseDTOs = songs.stream()
                .map(this::mapFromSongDTOToSongControllerResponseDTO)
                .toList();
        return new GetAllSongsResponseDTO(songControllerResponseDTOs);
    }

    GetSongResponseDTO mapFromSongToGetSongResponseDTO(SongDTO entity) {
        return new GetSongResponseDTO(entity.id(), entity.name(), entity.genre());
    }

    CreateSongResponseDTO mapFromSongToCreateSongResponseDTO(SongDTO entity) {
        return new CreateSongResponseDTO(entity.id(), entity.name(), entity.genre());
    }

    PartiallyUpdateSongResponseDTO mapFromSongDTOToPartiallyUpdateSongResponseDTO(SongDTO entity) {
        SongControllerResponseDTO songControllerResponseDTO = mapFromSongDTOToSongControllerResponseDTO(entity);
        return new PartiallyUpdateSongResponseDTO(songControllerResponseDTO);
    }

}
