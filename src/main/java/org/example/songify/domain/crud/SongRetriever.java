package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.SongDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongRetriever {

    private final SongRepository songRepository;
    private final SongifyDomainMapper mapper;

    List<SongDTO> findAll(final Pageable pageable) {
        List<Song> songs = songRepository.findAll(pageable);
        return songs.stream()
                .map(mapper::mapFromSongToSongDTO)
                .toList();
    }

    SongDTO findSongById(final Long id) {
        existsById(id);
        Song song = songRepository.findById(id);
        return mapper.mapFromSongToSongDTO(song);
    }

    Song getSongFromDB(final Long id) {
        existsById(id);
        return songRepository.findById(id);
    }

    void existsById(final Long id) {
        if (!songRepository.existsById(id)) {
            throw new SongNotFoundException("Song with id " + id + " not found");
        }
    }
}
