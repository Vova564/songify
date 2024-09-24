package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ArtistUpdater {
    private final ArtistRepository artistRepository;
    private final ArtistRetriever artistRetriever;

    void updateArtistNameById(final Long id, final String name) {
        artistRetriever.artistExistsById(id);
        artistRepository.updateNameById(id, name);
    }
}
