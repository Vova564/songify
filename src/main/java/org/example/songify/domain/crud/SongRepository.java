package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

interface SongRepository extends Repository<Song, Long> {

    @Query("SELECT s FROM Song s JOIN FETCH s.genre")
    List<Song> findAllSongs(Pageable pageable);

    @Query("SELECT s FROM Song s WHERE s.id = :id")
    Optional<Song> findById(Long id);

    @Modifying
    @Query("DELETE FROM Song s WHERE s.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Song s SET s.name = :name, s.releaseDate = :releaseDate, s.duration = :duration, s.language = :language  WHERE s.id = :id")
    void updateSongById(Long id, @Param("name") String name, @Param("releaseDate") Instant releaseDate, @Param("duration") Long duration, @Param("language") SongLanguage language);

    Song save(Song songToAdd);

    boolean existsById(Long id);
}
