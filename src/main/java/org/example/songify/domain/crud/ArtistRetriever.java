package org.example.songify.domain.crud;

import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ArtistRetriever {

    private final ArtistRepository artistRepository;
    private final SongifyDomainMapper mapper;

    Set<ArtistDTO> findAllArtists() {
        Set<Artist> artists = artistRepository.findAllArtists();
        return artists.stream()
                .map(mapper::mapFromArtistToArtistDTO)
                .collect(Collectors.toSet());
    }
}
