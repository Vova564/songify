package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongDeleter {

    private final SongRepository songRepository;
    private final SongRetriever songRetriever;
    private final GenreDeleter genreDeleter;

    void deleteById(final Long id) {
        songRetriever.songExistsById(id);
        songRepository.deleteById(id);
    }

    // Deleting song with cascade genre remover //
//    void deleteSongAndGenreById(final Long songId) {
//        Song song = songRetriever.getSongFromDB(songId);
//        Long genreId = song.getGenre().getId();
//
//        deleteById(songId);
//        genreDeleter.deleteById(genreId);
//    }

}
