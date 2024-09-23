package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ArtistAssigner {

    private final ArtistRetriever artistRetriever;
    private final AlbumRetriever albumRetriever;

    void addArtistToAlbum(final Long artistId, final Long albumId) {
        Artist artist = artistRetriever.getArtistByIdFromDb(artistId);
        Album album = albumRetriever.getAlbumByIdFromDb(albumId);
        artist.addAlbum(album);
    }
}
