package org.example.songify.domain.crud;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
class AlbumAdder {

    private final AlbumRepository albumRepository;
    private final SongifyDomainMapper mapper;
    private final SongRetriever songRetriever;

    AlbumDTO addAlbum(final AlbumRequestDTO albumRequestDTO) {
        Song song = songRetriever.getSongFromDB(albumRequestDTO.songId());
        Album album = mapper.mapFromAlbumRequestDTOToAlbum(albumRequestDTO, song);
        Album addedAlbum = albumRepository.save(album);
        return mapper.mapFromAlbumToAlbumDTO(addedAlbum);
    }
}
