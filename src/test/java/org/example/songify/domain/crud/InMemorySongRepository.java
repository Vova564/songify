package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class InMemorySongRepository implements SongRepository {
    @Override
    public List<Song> findAllSongs(final Pageable pageable) {
        return List.of();
    }

    @Override
    public Optional<Song> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(final Long id) {

    }

    @Override
    public void deleteSongsById(final Set<Long> songsIds) {

    }

    @Override
    public void updateSongById(final Long id, final String name, final Instant releaseDate, final Long duration, final SongLanguage language, final Long version) {

    }

    @Override
    public Song save(final Song songToAdd) {
        return null;
    }

    @Override
    public boolean existsById(final Long id) {
        return false;
    }
}
