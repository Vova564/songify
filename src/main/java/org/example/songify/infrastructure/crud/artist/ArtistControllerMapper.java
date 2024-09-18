package org.example.songify.infrastructure.crud.artist;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.infrastructure.crud.artist.dto.ArtistControllerResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.CreateArtistResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.GetAllArtistsResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
class ArtistControllerMapper {

    ArtistControllerResponseDTO mapFromArtistDTOToArtistControllerResponseDTO(ArtistDTO entity) {
        return ArtistControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    GetAllArtistsResponseDTO mapFromArtistDTOToGetAllArtistsResponseDTO(Set<ArtistDTO> entity) {
        Set<ArtistControllerResponseDTO> artistControllerResponseDTO = entity.stream()
                .map(this::mapFromArtistDTOToArtistControllerResponseDTO)
                .collect(Collectors.toSet());
        return new GetAllArtistsResponseDTO(artistControllerResponseDTO);
    }

    CreateArtistResponseDTO mapFromArtistDTOToCreateArtistResponseDTO(ArtistDTO entity) {
        ArtistControllerResponseDTO artistControllerResponseDTO = mapFromArtistDTOToArtistControllerResponseDTO(entity);
        return new CreateArtistResponseDTO(artistControllerResponseDTO);
    }
}
