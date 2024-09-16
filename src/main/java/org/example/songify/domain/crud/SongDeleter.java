package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongDeleter {

    private final SongRepository songRepository;
    private final SongRetriever songRetriever;

    void deleteSong(final Long id) {
        songRetriever.existsById(id);
        songRepository.deleteById(id);
    }
}
