package org.example.songify.domain.crud.song;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class SongDeleter {

    private final SongRepository songRepository;

    void deleteSong(Long id) {
        log.info("Delete song with id {}", id);
        songRepository.deleteById(id);
    }
}
