package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistUpdater {
    private final ArtistRepository artistRepository;
    private final ArtistRetriever artistRetriever;

    void updateArtistNameById(final Long id, final String name) {
        Artist artist = artistRetriever.getArtistByIdFromDb(id);
        artistRepository.updateNameByIdAndVersion(id, name, artist.version);
    }
}
