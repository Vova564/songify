package org.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Set;

interface ArtistRepository extends Repository<Artist, Long> {

    @Query("SELECT a FROM Artist a")
    Set<Artist> findAllArtists();

    Artist save(Artist artist);
}
