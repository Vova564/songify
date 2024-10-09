package org.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface GenreRepository extends Repository<Genre, Long> {

    @Query("SELECT g FROM Genre g WHERE g.id = :id")
    Optional<Genre> findById(Long id);

    @Modifying
    @Query("DELETE FROM Genre g WHERE g.id = :id")
    void deleteById(Long id);

    Genre save(Genre genre);

    boolean existsById(Long id);
}
