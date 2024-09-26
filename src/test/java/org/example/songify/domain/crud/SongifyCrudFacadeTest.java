package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.data.domain.Pageable;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SongifyCrudFacadeTest {

    SongifyCrudFacade songifyCrudFacade = SongifyCrudFacadeConfiguration.createSongifyCrud(
            new InMemorySongRepository(),
            new InMemoryGenreRepository(),
            new InMemoryArtistRepository(),
            new InMemoryAlbumRepository()
    );

    @Test
    @DisplayName("Should add artist 'Shawn Mendes' with id 0 When Shawn Mendes was sent")
    public void should_add_artist_shawn_mendes_with_id_zero_when_shawn_mendes_was_sent() {
        // Given
        ArtistRequestDTO artist = ArtistRequestDTO.builder()
                .name("Shawn Mendes")
                .build();

        Set<ArtistDTO> allArtists = songifyCrudFacade.findAllArtists(Pageable.unpaged());
        assertTrue(allArtists.isEmpty());

        // When
        ArtistDTO response = songifyCrudFacade.addArtist(artist);

        // Then
        assertThat(response.id()).isEqualTo(0L);
        assertThat(response.name()).isEqualTo("Shawn Mendes");
        int size = songifyCrudFacade.findAllArtists(Pageable.unpaged()).size();
        assertThat(size).isEqualTo(1);
    }

    @Test
    @DisplayName("Should add artist Ed Sheeran with id 0 when Ed Sheeran was sent")
    public void should_add_artist_ed_sheeran_with_id_zero_when_ed_sheeran_was_sent() {
        // Given
        ArtistRequestDTO artistRequestDTO = ArtistRequestDTO.builder()
                .name("Ed Sheeran")
                .build();

        Set<ArtistDTO> allArtists = songifyCrudFacade.findAllArtists(Pageable.unpaged());
        assertTrue(allArtists.isEmpty());

        // When
        ArtistDTO response = songifyCrudFacade.addArtist(artistRequestDTO);

        // Then
        assertThat(response.id()).isEqualTo(0L);
        assertThat(response.name()).isEqualTo("Ed Sheeran");
        int size = songifyCrudFacade.findAllArtists(Pageable.unpaged()).size();
        assertThat(size).isEqualTo(1);
    }

}