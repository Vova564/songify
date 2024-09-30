package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistDeleter {
    private final ArtistRepository artistRepository;
    private final ArtistRetriever artistRetriever;
    private final AlbumRetriever albumRetriever;
    private final AlbumDeleter albumDeleter;
    private final SongDeleter songDeleter;

    void deleteArtistByIdWithAlbumsAndSongs(final Long artistId) {
        Artist artist = artistRetriever.getArtistByIdFromDb(artistId);
        Set<Album> albums = albumRetriever.findAlbumsByArtistId(artistId);
        if (albums.isEmpty()) {
            artistRepository.deleteArtistsById(artistId);
        }

        Set<Album> albumsWithOnlyOneArtist = albums.stream()
                .filter(album -> album.getArtists().size() == 1)
                .collect(Collectors.toSet());

        Set<Long> allSongsIdsFromAllAlbumsWhereWasOnlyThisArtist = albumsWithOnlyOneArtist.stream()
                .flatMap(album -> album.getSongs().stream())
                .map(Song::getId)
                .collect(Collectors.toSet());

        songDeleter.deleteAllSongsById(allSongsIdsFromAllAlbumsWhereWasOnlyThisArtist);

        Set<Long> albumIdsToDelete = albumsWithOnlyOneArtist.stream()
                .map(Album::getId)
                .collect(Collectors.toSet());

        albumDeleter.deleteAllAlbumsByIds(albumIdsToDelete);

        albums.stream()
                .filter(album -> album.getArtists().size() >= 2)
                .forEach(album -> album.removeArtist(artist));

        artistRepository.deleteArtistsById(artistId);
    }
}
