package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryArtistRepository implements ArtistRepository {

    Map<Long, Artist> db = new HashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public List<Artist> findAllArtists(final Pageable pageable) {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Artist> findArtistById(final Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteArtistsById(final Long id) {

    }

    @Override
    public void updateNameByIdAndVersion(final Long id, final String name, final Long version) {

    }

    @Override
    public Artist save(final Artist artist) {
        long id = this.index.getAndIncrement();
        db.put(id, artist);
        artist.setId(id);
        return artist;
    }
}
