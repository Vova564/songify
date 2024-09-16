package org.example.songify.infrastructure.crud.album;

import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.infrastructure.crud.album.dto.AlbumControllerResponseDTO;
import org.example.songify.infrastructure.crud.album.dto.CreateAlbumResponseDTO;

class AlbumContorllerMapper {

    static AlbumControllerResponseDTO mapFromAlbumDTOToAlbumControllerResponseDTO(AlbumDTO entity) {
        return AlbumControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    static CreateAlbumResponseDTO mapFromAlbumDTOToCreateAlbumResponseDTO(AlbumDTO entity) {
        AlbumControllerResponseDTO albumControllerResponseDTO = mapFromAlbumDTOToAlbumControllerResponseDTO(entity);
        return new CreateAlbumResponseDTO(albumControllerResponseDTO);
    }
}
