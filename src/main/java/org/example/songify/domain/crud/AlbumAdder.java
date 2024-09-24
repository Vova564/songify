package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
class AlbumAdder {

    private final AlbumRepository albumRepository;
    private final SongifyDomainMapper mapper;
    private final SongRetriever songRetriever;

    Album addAlbum(final String name, final Instant releaseDate) {
        Album album = new Album(name , releaseDate);
        return albumRepository.save(album);
    }

    AlbumDTO addAlbumWithSong(final AlbumRequestDTO albumRequestDTO) {
        Song song = songRetriever.getSongFromDB(albumRequestDTO.songId());
        Album album = mapper.mapFromAlbumRequestDTOToAlbum(albumRequestDTO, song);
        Album addedAlbum = albumRepository.save(album);
        return mapper.mapFromAlbumToAlbumDTO(addedAlbum);
    }

}
