package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongUpdater {

    private final SongRepository songRepository;

    void updateById(Long id, Song newSong) {
        songRepository.updateById(id, newSong);
        log.info("Song updated: {}", newSong);
    }

    Song updatePartiallyById(Long id, Song songFromRequest, Song songFromDatabase) {
        Song.SongBuilder builder = Song.builder();

        if (songFromRequest.getSong() != null) {
            builder.song(songFromRequest.getSong());
        } else {
            builder.song(songFromDatabase.getSong());
        }

        if (songFromRequest.getArtist() != null) {
            builder.artist(songFromRequest.getArtist());
        } else {
            builder.artist(songFromDatabase.getArtist());
        }

        Song songToSave = builder.build();
        updateById(id, songToSave);
        return songToSave;
    }

// Dirty Checking
//    public void updateById(Long id, Song newSong) {
//        Song songById = songRetriever.findSongById(id);
//        songById.setArtist(newSong.getArtist());
//        songById.setSong(newSong.getSong());
//        log.info("Song updated: {}", newSong);
//
//    }
//
//    public Song updatePartiallyById(Long id, Song songFromRequest) {
//        Song songFromDatabase = songRetriever.findSongById(id);
//
//        if (songFromRequest.getArtist() != null) {
//            songFromDatabase.setArtist(songFromRequest.getArtist());
//        }
//
//        if (songFromRequest.getSong() != null) {
//            songFromDatabase.setSong(songFromRequest.getSong());
//        }
//
//        return songFromDatabase;
//    }

}
