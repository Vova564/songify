package org.example.songify.domain.crud;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface ArtistRepository extends Repository<Artist, Long> {

    @Query("SELECT a FROM Artist a")
    List<Artist> findAllArtists(Pageable pageable);

    Artist save(Artist artist);
}
