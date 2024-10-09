package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class InMemorySongRepository implements SongRepository {

    Map<Long, Song> db = new HashMap<>();
    AtomicInteger index = new AtomicInteger(0);

    @Override
    public List<Song> findAllSongs(final Pageable pageable) {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Song> findById(final Long id) {
        Song song = db.get(id);
        return Optional.ofNullable(song);
    }

    @Override
    public void deleteById(final Long id) {

    }

    @Override
    public void deleteSongsById(final Set<Long> songsIds) {
        songsIds.forEach(
                id -> db.remove(id)
        );
    }

    @Override
    public void updateSongById(final Long id, final String name, final Instant releaseDate, final Long duration, final SongLanguage language, final Long version) {

    }

    @Override
    public Song save(final Song songToAdd) {
        long id = this.index.getAndIncrement();
        db.put(id, songToAdd);
        songToAdd.setId(id);
        return songToAdd;
    }

    @Override
    public boolean existsById(final Long id) {
        return false;
    }

    @Override
    public Set<Song> findSongsByIds(final Set<Long> ids) {
        return db.values().stream()
                .filter(song -> ids.contains(song.getId()))
                .collect(Collectors.toSet());
    }
}
