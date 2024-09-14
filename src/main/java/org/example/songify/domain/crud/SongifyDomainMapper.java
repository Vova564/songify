package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.SongDTO;

class SongifyDomainMapper {

    static SongDTO mapFromSongToSongDTO(Song entity) {
        return SongDTO.builder()
                .id(entity.getId())
                .song(entity.getSong())
                .build();
    }

    static Song mapFromSongDTOToSong(SongDTO songDTO) {
        return new Song(songDTO.song());
    }

    static ArtistDTO mapFromArtistToArtistDTO(Artist entity) {
        return ArtistDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static Artist mapFromArtistRequestDTOToArtist(ArtistRequestDTO artistRequestDTO) {
        return new Artist(artistRequestDTO.name());
    }
}
