package org.example.songify.domain.crud;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Transactional
class SongUpdater {

    private final SongRepository songRepository;
    private final SongifyDomainMapper mapper;
    private final SongRetriever songRetriever;

    void updateSongById(final Long id, final SongRequestDTO songRequestDTO) {
        songRetriever.songExistsById(id);
        Song song = mapper.mapFromSongRequestDTOToSong(songRequestDTO);
        songRepository.updateSongById(id, song.getName(), song.getReleaseDate(), song.getDuration(), song.getLanguage());
    }

    SongDTO updateSongPartiallyById(final Long id, final SongRequestDTO songRequestDTO) {
        Song songFromDatabase = songRetriever.getSongFromDB(id);
        Song songFromRequest = mapper.mapFromSongRequestDTOToSong(songRequestDTO);
        Song.SongBuilder builder = Song.builder();

        if (songFromRequest.getName() != null) {
            builder.name(songFromRequest.getName());
        } else {
            builder.name(songFromDatabase.getName());
        }

        if (songFromRequest.getReleaseDate() != null) {
            builder.releaseDate(songFromRequest.getReleaseDate());
        } else {
            builder.releaseDate(songFromDatabase.getReleaseDate());
        }

        if (songFromRequest.getDuration() != null) {
            builder.duration(songFromRequest.getDuration());
        } else {
            builder.duration(songFromDatabase.getDuration());
        }

        if (songFromRequest.getLanguage() != null) {
            builder.language(songFromRequest.getLanguage());
        } else {
            builder.language(songFromDatabase.getLanguage());
        }

        Song songToSave = builder.build();
        SongRequestDTO songRequestDTOToSave = mapper.mapFromSongToSongRequestDTO(songToSave);

        updateSongById(id, songRequestDTOToSave);
        return mapper.mapFromSongToSongDTO(songToSave);
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
