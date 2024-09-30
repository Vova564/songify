package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.exception.ArtistNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistRetriever {

    private final ArtistRepository artistRepository;
    private final SongifyDomainMapper mapper;

    Set<ArtistDTO> findAllArtists(Pageable pageable) {
        List<Artist> artists = artistRepository.findAllArtists(pageable);
        return artists.stream()
                .map(mapper::mapFromArtistToArtistDTO)
                .collect(Collectors.toSet());
    }

    ArtistDTO findArtistById(final Long id) {
         Artist artist = artistRepository.findArtistById(id)
                .orElseThrow(() -> new ArtistNotFoundException(id));
         return mapper.mapFromArtistToArtistDTO(artist);
    }

    Artist getArtistByIdFromDb(Long id) {
        return artistRepository.findArtistById(id)
                .orElseThrow(() -> new ArtistNotFoundException(id));
    }

}
