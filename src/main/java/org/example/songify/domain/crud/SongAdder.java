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

    SongDTO addSong(final SongRequestDTO songRequestDTO) {
        Song song = mapper.mapFromSongRequestDTOToSong(songRequestDTO);
        Song addedSong = songRepository.save(song);
        return mapper.mapFromSongToSongDTO(addedSong);
    }

}
