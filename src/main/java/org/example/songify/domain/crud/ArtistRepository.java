package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ArtistRepository extends Repository<Artist, Long> {

    @Query("SELECT a FROM Artist a")
    List<Artist> findAllArtists(Pageable pageable);

    @Query("SELECT a FROM Artist a WHERE a.id = :id")
    Optional<Artist> findArtistById(Long id);

    @Modifying
    @Query("DELETE FROM Artist a WHERE a.id = :id")
    void deleteArtistsById(Long id);

    @Modifying
    @Query("UPDATE Artist a SET a.name = :name WHERE a.id = :id")
    void updateNameById(Long id, String name);

    Artist save(Artist artist);

    boolean existsById(Long id);
}
