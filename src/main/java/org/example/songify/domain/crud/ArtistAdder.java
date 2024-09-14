package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistAdder {

    private final ArtistRepository artistRepository;

    Artist addArtist(Artist artist) {
        log.info("Adding new artist: {}", artist);
        return artistRepository.save(artist);
    }
}
