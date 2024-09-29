package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.domain.crud.dto.AlbumWithArtistsAndSongsDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.dto.SongLanguageDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class SongifyDomainMapper {

    // SongLanguage //
    SongLanguage mapFromSongLanguageDTOToSongLanguage(SongLanguageDTO songLanguageDTO) {
        return SongLanguage.valueOf(songLanguageDTO.name());
    }


    SongLanguageDTO mapFromSongLanguageToSongLanguageDTO(SongLanguage songLanguage) {
        return SongLanguageDTO.valueOf(songLanguage.name());
    }

    // Song //
    SongDTO mapFromSongToSongDTO(Song entity) {
        return SongDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    Song mapFromSongRequestDTOToSong(SongRequestDTO songRequestDTO) {
        SongLanguage language = mapFromSongLanguageDTOToSongLanguage(songRequestDTO.language());
        return new Song(songRequestDTO.name(), songRequestDTO.releaseDate(), songRequestDTO.duration(), language);
    }

    SongRequestDTO mapFromSongToSongRequestDTO(Song entity) {
        SongLanguageDTO language = mapFromSongLanguageToSongLanguageDTO(entity.getLanguage());
        return SongRequestDTO.builder()
                .name(entity.getName())
                .releaseDate(entity.getReleaseDate())
                .duration(entity.getDuration())
                .language(language)
                .build();
    }

    // Artist //
    ArtistDTO mapFromArtistToArtistDTO(Artist entity) {
        return ArtistDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    Artist mapFromArtistRequestDTOToArtist(ArtistRequestDTO artistRequestDTO) {
        return new Artist(artistRequestDTO.name());
    }

    // Genre //
    GenreDTO mapFromGenreToGenreDTO(Genre entity) {
        return GenreDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    Genre mapFromGenreRequestDTOToGenre(GenreRequestDTO genreRequestDTO) {
        return new Genre(genreRequestDTO.name());
    }

    // Album //
    AlbumDTO mapFromAlbumToAlbumDTO(Album entity) {
        return AlbumDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    Album mapFromAlbumRequestDTOToAlbum(AlbumRequestDTO albumRequestDTO, Song song) {
        Album album = new Album(albumRequestDTO.name(), albumRequestDTO.releaseDate());
        album.addSong(song);
        return album;
    }

    AlbumWithArtistsAndSongsDTO mapFromAlbumDTOAndArtistDTOAndSongDTOToAlbumWithArtistsAndSongsDTO(final AlbumDTO albumDTO, final Set<ArtistDTO> artistsDTO, final Set<SongDTO> songsDTO) {
        return AlbumWithArtistsAndSongsDTO.builder()
                .album(albumDTO)
                .artists(artistsDTO)
                .songs(songsDTO)
                .build();
    }
}
