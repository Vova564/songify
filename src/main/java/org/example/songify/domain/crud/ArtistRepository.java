package org.example.songify.domain.crud;

import org.springframework.data.repository.Repository;

interface ArtistRepository extends Repository<Song, Long> {

    Artist save(Artist artist);
}
