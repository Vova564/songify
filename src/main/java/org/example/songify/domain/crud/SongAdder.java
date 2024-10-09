package org.example.songify.domain.crud;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongAdder {

    private final SongRepository songRepository;
    private final SongifyDomainMapper mapper;
    private final GenreAssigner genreAssigner;

    SongDTO addSong(final SongRequestDTO songRequestDTO) {
        Song song = mapper.mapFromSongRequestDTOToSong(songRequestDTO);
        Song addedSong = songRepository.save(song);
        genreAssigner.assignigDefaultGenreToSong(song.getId());
        return mapper.mapFromSongToSongDTO(addedSong);
    }

    Song addSongAndGetEntity(final SongRequestDTO songRequestDTO) {
        Song song = mapper.mapFromSongRequestDTOToSong(songRequestDTO);
        return songRepository.save(song);
    }

}
