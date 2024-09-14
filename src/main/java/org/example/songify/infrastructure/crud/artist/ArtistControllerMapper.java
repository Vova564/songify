package org.example.songify.infrastructure.crud.artist;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.infrastructure.crud.artist.dto.request.CreateArtistRequestBodyDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.ArtistControllerResponseDTO;
import org.example.songify.infrastructure.crud.artist.dto.response.CreateArtistResponseDTO;

public class ArtistControllerMapper {

    static ArtistDTO mapFromCreateArtistRequestBodyDTOToArtistDTO(CreateArtistRequestBodyDTO requestBody) {
        return ArtistDTO.builder()
                .name(requestBody.name())
                .build();
    }

    static ArtistControllerResponseDTO mapFromArtistDTOToArtistControllerResponseDTO(ArtistDTO entity) {
        return ArtistControllerResponseDTO.builder()
                .name(entity.name())
                .build();
    }

    static CreateArtistResponseDTO mapFromArtistDTOToCreateArtistResponseDTO(ArtistDTO entity) {
        ArtistControllerResponseDTO artistControllerResponseDTO = mapFromArtistDTOToArtistControllerResponseDTO(entity);
        return new CreateArtistResponseDTO(artistControllerResponseDTO);
    }
}
