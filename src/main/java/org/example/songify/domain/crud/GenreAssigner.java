package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class GenreAssigner {

    private final SongRetriever songRetriever;
    private final GenreRetriever genreRetriever;

    void assignigDefaultGenreToSong(final Long songId) {
        Song song = songRetriever.getSongByIdFromDb(songId);
        Genre genre = genreRetriever.getGenreByIdFromDb(1L);
        song.setGenre(genre);
    }
}
