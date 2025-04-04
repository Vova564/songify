package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumWithArtistsAndSongsDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.exception.AlbumNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class AlbumRetriever {

    private final AlbumRepository albumRepository;
    private final SongifyDomainMapper mapper;

    Set<AlbumDTO> findAllAlbums() {
        Set<Album> albums = albumRepository.findAllAlbums();
        return albums.stream()
                .map(mapper::mapFromAlbumToAlbumDTO)
                .collect(Collectors.toSet());
    }

    AlbumDTO findAlbumById(final Long id) {
        Album album = albumRepository.findAlbumById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
        return mapper.mapFromAlbumToAlbumDTO(album);
    }

    AlbumWithArtistsAndSongsDTO findAlbumByIdWithArtistsAndSongs(final Long id) {

        Album album = albumRepository.findAlbumByIdWithArtistsAndSongs(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));

        Set<Artist> artists = album.getArtists();
        Set<Song> songs = album.getSongs();

        AlbumDTO albumDTO = mapper.mapFromAlbumToAlbumDTO(album);

        Set<ArtistDTO> artistsDTO = artists.stream()
                .map(mapper::mapFromArtistToArtistDTO)
                .collect(Collectors.toSet());

        Set<SongDTO> songsDTO = songs.stream()
                .map(mapper::mapFromSongToSongDTO)
                .collect(Collectors.toSet());

        return mapper.mapFromAlbumDTOAndArtistDTOAndSongDTOToAlbumWithArtistsAndSongsDTO(albumDTO, artistsDTO, songsDTO);
    }

    Set<Album> findAlbumsByArtistId(final Long id) {
        return albumRepository.findAlbumsByArtistId(id);
    }

    Set<AlbumDTO> findAlbumsByArtistIdReturnAlbumDTO(final Long id) {
        return findAlbumsByArtistId(id).stream()
                .map(mapper::mapFromAlbumToAlbumDTO)
                .collect(Collectors.toSet());
    }

    Album getAlbumByIdFromDb(final Long id) {
        return albumRepository.findAlbumById(id)
                .orElseThrow(() -> new AlbumNotFoundException(id));
    }
}
