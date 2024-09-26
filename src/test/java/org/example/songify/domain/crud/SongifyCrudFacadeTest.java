package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.exception.ArtistNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.data.domain.Pageable;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
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
    @DisplayName("Should add artist Ed Sheeran with id 0 When Ed Sheeran was sent")
    public void should_add_artist_ed_sheeran_with_id_zero_when_ed_sheeran_was_sent() {
        // Given
        ArtistRequestDTO artist = ArtistRequestDTO.builder()
                .name("Ed Sheeran")
                .build();

        Set<ArtistDTO> allArtists = songifyCrudFacade.findAllArtists(Pageable.unpaged());
        assertTrue(allArtists.isEmpty());

        // When
        ArtistDTO response = songifyCrudFacade.addArtist(artist);

        // Then
        assertThat(response.id()).isEqualTo(0L);
        assertThat(response.name()).isEqualTo("Ed Sheeran");
        int size = songifyCrudFacade.findAllArtists(Pageable.unpaged()).size();
        assertThat(size).isEqualTo(1);
    }

    @Test
    @DisplayName("Should throw exception ArtistNotFound When id 1")
    public void should_throw_exception_artist_not_found_when_id_was_one() {
        // Given
        assertThat(songifyCrudFacade.findAllArtists(Pageable.unpaged())).isEmpty();

        // When
        Throwable throwable = catchThrowable(() -> songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(1L));

        // Then
        assertThat(throwable).isInstanceOf(ArtistNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Artist with id 1 not found");
    }

    @Test
    @DisplayName("Should delete artist When he have no albums")
    public void should_delete_artist_when_he_have_no_albums() {
        // Given
        ArtistRequestDTO artist = ArtistRequestDTO.builder()
                .name("Shawn Mendes")
                .build();

        ArtistDTO artistDTO = songifyCrudFacade.addArtist(artist);
        assertThat(songifyCrudFacade.findAllArtists(Pageable.unpaged())).isNotEmpty();
        Long artistId = artistDTO.id();

        Set<AlbumDTO> albums = songifyCrudFacade.findAlbumsByArtistId(artistId);
        assertThat(albums).isEmpty();

        // When
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(artistId);

        // Then
        assertThat(songifyCrudFacade.findAllArtists(Pageable.unpaged())).isEmpty();

    }

}