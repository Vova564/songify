package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.ArtistDTO;
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
                .name(entity.getName())
                .build();
    }

    static Artist mapFromArtistDTOToArtist(ArtistDTO artistDTO) {
        return new Artist(artistDTO.name());
    }

//    public static Song mapFromCreateSongRequestDTOToSong(CreateSongRequestBodyDTO dto) {
//        return new Song(dto.artist(), dto.song());
//    }
//
//    public static Song mapFromUpdateSongRequestBodyDTOToSong(UpdateSongRequestBodyDTO dto) {
//        return new Song(dto.artist(), dto.song());
//    }
//
//    public static Song mapFromPartiallyUpdateSongRequestBodyDTOToSong(PartiallyUpdateSongRequestBodyDTO dto) {
//        return new Song(dto.artist(), dto.song());
//    }

}
