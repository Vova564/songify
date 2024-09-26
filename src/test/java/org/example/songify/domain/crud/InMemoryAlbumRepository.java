package org.example.songify.domain.crud;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

class InMemoryAlbumRepository implements AlbumRepository {
    @Override
    public Optional<Album> findAlbumByIdWithArtistsAndSongs(final Long id) {
        return Optional.empty();
    }

    @Override
    public Set<Album> findAlbumsByArtistId(final Long id) {
        return Set.of();
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
