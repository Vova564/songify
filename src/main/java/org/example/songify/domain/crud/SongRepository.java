package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

interface SongRepository extends Repository<Song, Long> {

    @Query("SELECT s FROM Song s JOIN FETCH s.genre")
    List<Song> findAllSongs(Pageable pageable);

    @Query("SELECT s FROM Song s WHERE s.id = :id")
    Optional<Song> findById(Long id);

    @Modifying
    @Query("DELETE FROM Song s WHERE s.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("DELETE FROM Song s WHERE s.id IN :songsIds")
    void deleteSongsById(Set<Long> songsIds);

    @Modifying
    @Query("UPDATE Song s SET s.name = :name, s.releaseDate = :releaseDate, s.duration = :duration, s.language = :language, s.version = :version + 1  WHERE s.id = :id AND s.version = :version")
    void updateSongById(Long id, String name, Instant releaseDate, Long duration, SongLanguage language, Long version);

    Song save(Song songToAdd);

    boolean existsById(Long id);
}
