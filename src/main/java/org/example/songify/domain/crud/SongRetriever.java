package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.exception.SongNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongRetriever {

    private final SongRepository songRepository;
    private final SongifyDomainMapper mapper;

    List<SongDTO> findAllSongs(final Pageable pageable) {
        List<Song> songs = songRepository.findAllSongs(pageable);
        return songs.stream()
                .map(mapper::mapFromSongToSongDTO)
                .toList();
    }

    SongDTO findSongById(final Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
        return mapper.mapFromSongToSongDTO(song);
    }

    Song getSongByIdFromDb(final Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    void songExistsById(final Long id) {
        if (!songRepository.existsById(id)) {
            throw new SongNotFoundException(id);
        }
    }
}
