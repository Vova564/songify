package org.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface AlbumRepository extends Repository<Album, Long> {

    @Query("SELECT a FROM Album a JOIN FETCH a.songs songs JOIN FETCH a.artists artists WHERE a.id = :id")
    Optional<Album> findAlbumByIdWithArtistsAndSongs(Long id);

    Album save(Album album);

}
