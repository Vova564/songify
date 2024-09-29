package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.SongLanguageDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.example.songify.domain.crud.exception.AlbumNotFoundException;
import org.example.songify.domain.crud.exception.ArtistNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.data.domain.Pageable;

import java.time.Instant;
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
    @DisplayName("Should add artist")
    public void should_add_artist() {
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
    @DisplayName("Should throw exception When artist not found")
    public void should_throw_exception_when_artist_not_found() {
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

        Long artistId = songifyCrudFacade.addArtist(artist).id();

        Set<AlbumDTO> albums = songifyCrudFacade.findAlbumsByArtistId(artistId);
        assertThat(albums).isEmpty();

        // When
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(artistId);

        // Then
        assertThat(songifyCrudFacade.findAllArtists(Pageable.unpaged())).isEmpty();
    }

    @Test
    @DisplayName("Should delete artist with album and songs When artist have one album and is only artist in the album")
    public void should_delete_artist_with_album_and_songs_when_artist_have_one_album_and_is_only_artist_in_the_album() {
        // Given
        ArtistRequestDTO artist = ArtistRequestDTO.builder()
                .name("Shawn Mendes")
                .build();
        Long artistId = songifyCrudFacade.addArtist(artist).id();

        SongRequestDTO song = SongRequestDTO.builder()
                .name("Imagine")
                .releaseDate(Instant.now())
                .duration(123L)
                .language(SongLanguageDTO.ENGLISH)
                .build();
        Long songId = songifyCrudFacade.addSong(song).id();

        AlbumRequestDTO album = AlbumRequestDTO.builder()
                .name("Album name")
                .releaseDate(Instant.now())
                .songId(songId)
                .build();
        Long albumId = songifyCrudFacade.addAlbumWithSong(album).id();

        songifyCrudFacade.addArtistToAlbum(artistId, albumId);

        assertThat(songifyCrudFacade.findAlbumsByArtistId(artistId).size()).isEqualTo(1);
        assertThat(songifyCrudFacade.findAlbumByIdWithArtistsAndSongs(albumId).artists().size()).isEqualTo(1);

        // When
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(artistId);

        // Then
        assertThat(songifyCrudFacade.findAllArtists(Pageable.unpaged())).isEmpty();
        assertThat(songifyCrudFacade.findAllSongs(Pageable.unpaged())).isEmpty();

        Throwable throwable = catchThrowable(() -> songifyCrudFacade.findAlbumById(albumId));
        assertThat(throwable).isInstanceOf(AlbumNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Album with id " + albumId + " not found");

    }

    @Test
    @DisplayName("Should add album with song")
    public void should_add_album_with_song() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should add song")
    public void should_add_song() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should return album by id")
    public void should_return_album_by_id() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should throw exception When album not found")
    public void should_throw_exception_when_album_not_found() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should throw exception When album not found")
    public void should_throw_exception_when_song_not_found() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should add artist to album")
    public void should_add_artist_to_album() {
        //TODO
        // Given

        // When

        // Then
    }

    @Test
    @DisplayName("Should return artist by id")
    public void should_return_artist_by_id() {
        //TODO
        // Given

        // When

        // Then
    }
}