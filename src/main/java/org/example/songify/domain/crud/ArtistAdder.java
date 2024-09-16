package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class ArtistAdder {

    private final ArtistRepository artistRepository;
    private final SongifyDomainMapper mapper;

    ArtistDTO addArtist(final ArtistRequestDTO artistRequestDTO) {
        Artist artist = mapper.mapFromArtistRequestDTOToArtist(artistRequestDTO);
        Artist addedArtist = artistRepository.save(artist);
        return mapper.mapFromArtistToArtistDTO(addedArtist);
    }
}
