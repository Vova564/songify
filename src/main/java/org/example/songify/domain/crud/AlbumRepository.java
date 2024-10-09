package org.example.songify.domain.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

interface AlbumRepository extends Repository<Album, Long> {

    @Query("SELECT a FROM Album a")
    Set<Album> findAllAlbums();

    @Query("SELECT a FROM Album a JOIN FETCH a.songs songs JOIN FETCH a.artists artists WHERE a.id = :id")
    Optional<Album> findAlbumByIdWithArtistsAndSongs(Long id);

    @Query("SELECT a FROM Album a JOIN FETCH a.artists artists WHERE artists.id = :id")
    Set<Album> findAlbumsByArtistId(Long id);

    @Query("SELECT a FROM Album a WHERE a.id = :id")
    Optional<Album> findAlbumById(Long id);

    @Modifying
    @Query("DELETE FROM Album a WHERE a.id IN :ids")
    void deleteAlbumsById(Set<Long> ids);

    Album save(Album album);

}
