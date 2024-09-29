package org.example.songify.domain.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class InMemoryAlbumRepository implements AlbumRepository {

    Map<Long, Album> db = new HashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public Optional<Album> findAlbumByIdWithArtistsAndSongs(final Long id) {
        Album album = db.get(id);
        Set<Artist> artists = album.getArtists();
        Set<Song> songs = album.getSongs();
        Album newAlbum = new Album(album.getId(), album.getName(), album.getReleaseDate(), songs, artists);
        return Optional.of(newAlbum);
    }

    @Override
    public Set<Album> findAlbumsByArtistId(final Long id) {
        return db.values().stream()
                .filter(album -> album.getArtists().stream()
                        .anyMatch(artist -> artist.getId().equals(id)))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Album> findAlbumById(final Long id) {
        Album album = db.get(id);
        return Optional.ofNullable(album);
    }

    @Override
    public void deleteAlbumsById(final Set<Long> ids) {
        ids.forEach(
                id -> db.remove(id)
        );
    }

    @Override
    public Album save(final Album album) {
        long id = this.index.getAndIncrement();
        db.put(id, album);
        album.setId(id);
        return album;
    }
}
