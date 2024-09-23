package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class AlbumDeleter {

    private final AlbumRepository albumRepository;

    void deleteAllAlbumsByIds(final Set<Long> albumIdsToDelete) {
        albumRepository.deleteAlbumsById(albumIdsToDelete);
    }
}
