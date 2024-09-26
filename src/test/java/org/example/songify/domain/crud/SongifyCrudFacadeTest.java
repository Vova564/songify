package org.example.songify.domain.crud;

import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.junit.jupiter.api.Test;

class SongifyCrudFacadeTest {

    SongifyCrudFacade songifyCrudFacade = SongifyCrudFacadeConfiguration.createSongifyCrud(
            new InMemorySongRepository(),
            new InMemoryGenreRepository(),
            new InMemoryArtistRepository(),
            new InMemoryAlbumRepository()
    );

    @Test
    public void test() {
        ArtistRequestDTO artistRequestDTO = ArtistRequestDTO.builder()
                .name("Shawn Mendes")
                .build();

        ArtistDTO artistDTO = songifyCrudFacade.addArtist(artistRequestDTO);
    }

}