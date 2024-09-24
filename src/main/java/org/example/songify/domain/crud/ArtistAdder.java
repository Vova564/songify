package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.SongLanguageDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistAdder {

    private final ArtistRepository artistRepository;
    private final SongifyDomainMapper mapper;
    private final AlbumAdder albumAdder;
    private final SongAdder songAdder;

    ArtistDTO addArtist(final ArtistRequestDTO artistRequestDTO) {
        Artist artist = mapper.mapFromArtistRequestDTOToArtist(artistRequestDTO);
        Artist addedArtist = artistRepository.save(artist);
        return mapper.mapFromArtistToArtistDTO(addedArtist);
    }

    ArtistDTO addArtistWithDefaultAlbumAndSong(final ArtistRequestDTO artistRequestDTO) {
        Artist artistToSave = saveArtistWithDefaultAlbumAndSong(artistRequestDTO.name());
        return mapper.mapFromArtistToArtistDTO(artistToSave);
    }

    private Artist saveArtistWithDefaultAlbumAndSong(final String name) {
        Album album = albumAdder.addAlbum("default-album: " + UUID.randomUUID(), LocalDateTime.now().toInstant(ZoneOffset.UTC));
        SongRequestDTO songRequestDTO = new SongRequestDTO("default-song-name: " + UUID.randomUUID(), LocalDateTime.now().toInstant(ZoneOffset.UTC), 100L, SongLanguageDTO.OTHER);
        Song song = songAdder.addSongAndGetEntity(songRequestDTO);

        Artist artist = new Artist(name);
        album.addSong(song);
        artist.addAlbum(album);
        return artistRepository.save(artist);
    }
}
