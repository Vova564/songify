package org.example.songify.infrastructure.crud.album;

import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumWithArtistsAndSongsDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.infrastructure.crud.album.dto.AlbumControllerResponseDTO;
import org.example.songify.infrastructure.crud.album.dto.CreateAlbumResponseDTO;
import org.example.songify.infrastructure.crud.album.dto.GetAlbumWithArtistsAndSongsResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
class AlbumControllerMapper {

    AlbumControllerResponseDTO mapFromAlbumDTOToAlbumControllerResponseDTO(AlbumDTO entity) {
        return AlbumControllerResponseDTO.builder()
                .id(entity.id())
                .name(entity.name())
                .build();
    }

    CreateAlbumResponseDTO mapFromAlbumDTOToCreateAlbumResponseDTO(AlbumDTO entity) {
        AlbumControllerResponseDTO albumControllerResponseDTO = mapFromAlbumDTOToAlbumControllerResponseDTO(entity);
        return new CreateAlbumResponseDTO(albumControllerResponseDTO);
    }

    GetAlbumWithArtistsAndSongsResponseDTO mapFromAlbumWithArtistsAndSongsDTOToGetAlbumWithArtistsAndSongsResponseDTO(AlbumWithArtistsAndSongsDTO albumWithArtistsAndSongsDTO) {
        AlbumControllerResponseDTO albumControllerResponseDTO = AlbumControllerResponseDTO.builder()
                .id(albumWithArtistsAndSongsDTO.album().id())
                .name(albumWithArtistsAndSongsDTO.album().name())
                .build();

        Set<String> artists = albumWithArtistsAndSongsDTO.artists().stream()
                .map(ArtistDTO::name)
                .collect(Collectors.toSet());

        Set<String> songs = albumWithArtistsAndSongsDTO.songs().stream()
                .map(SongDTO::name)
                .collect(Collectors.toSet());

        return GetAlbumWithArtistsAndSongsResponseDTO.builder()
                .album(albumControllerResponseDTO)
                .artists(artists)
                .songs(songs)
                .build();
    }

}
