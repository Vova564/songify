package org.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

interface AlbumRepository extends Repository<Album, Long> {

    @Query("SELECT a FROM Album a JOIN FETCH a.songs songs JOIN FETCH a.artists artists WHERE a.id = :id")
    Optional<Album> findAlbumByIdWithArtistsAndSongs(Long id);

    @Query("SELECT a FROM Album a JOIN FETCH a.artists artists WHERE artists.id = :id")
    Set<Album> findAlbumsByArtistId(Long id);

    @Query("SELECT a FROM Album a WHERE a.id = :id")
    Album findAlbumById(Long id);

    @Modifying
    @Query("DELETE FROM Album a WHERE a.id IN :id")
    void deleteAlbumsById(Collection<Long> id);

    Album save(Album album);

}
