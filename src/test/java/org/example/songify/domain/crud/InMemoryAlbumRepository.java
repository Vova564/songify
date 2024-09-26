package org.example.songify.domain.crud;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class InMemoryAlbumRepository implements AlbumRepository {

    Map<Long, Album> db = new HashMap<>();

    @Override
    public Optional<Album> findAlbumByIdWithArtistsAndSongs(final Long id) {
        return Optional.empty();
    }

    @Override
    public Set<Album> findAlbumsByArtistId(final Long id) {
        return db.values().stream()
                .filter(album -> album.getArtists().stream()
                        .anyMatch(artist -> artist.getId().equals(id)))
                .collect(Collectors.toSet());
    }

    @Override
    public Album findAlbumById(final Long id) {
        return null;
    }

    @Override
    public void deleteAlbumsById(final Collection<Long> id) {

    }

    @Override
    public Album save(final Album album) {
        return null;
    }
}
