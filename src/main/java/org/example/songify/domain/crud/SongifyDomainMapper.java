package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.example.songify.domain.crud.dto.SongDTO;

class SongifyDomainMapper {

    // Song //
    static SongDTO mapFromSongToSongDTO(Song entity) {
        return SongDTO.builder()
                .id(entity.getId())
                .song(entity.getSong())
                .build();
    }

    static Song mapFromSongDTOToSong(SongDTO songDTO) {
        return new Song(songDTO.song());
    }

    // Artist //
    static ArtistDTO mapFromArtistToArtistDTO(Artist entity) {
        return ArtistDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static Artist mapFromArtistRequestDTOToArtist(ArtistRequestDTO artistRequestDTO) {
        return new Artist(artistRequestDTO.name());
    }

    // Genre //
    static GenreDTO mapFromGenreToGenreDTO(Genre entity) {
        return GenreDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    static Genre mapFromGenreRequestDTOToGenre(GenreRequestDTO genreRequestDTO) {
        return new Genre(genreRequestDTO.name());
    }
}
