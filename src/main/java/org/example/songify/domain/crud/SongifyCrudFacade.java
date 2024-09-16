package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.ArtistRequestDTO;
import org.example.songify.domain.crud.dto.GenreDTO;
import org.example.songify.domain.crud.dto.GenreRequestDTO;
import org.example.songify.domain.crud.dto.SongDTO;
import org.example.songify.domain.crud.dto.SongRequestDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SongifyCrudFacade {

    private final SongRetriever songRetriever;
    private final SongAdder songAdder;
    private final SongDeleter songDeleter;
    private final SongUpdater songUpdater;
    private final ArtistAdder artistAdder;
    private final ArtistRetriever artistRetriever;
    private final GenreAdder genreAdder;
    private final AlbumAdder albumAdder;

    public List<SongDTO> findAll(final Pageable pageable) {
        return songRetriever.findAll(pageable);
    }

    public SongDTO findSongById(Long id) {
        return songRetriever.findSongById(id);
    }

    public SongDTO addSong(SongRequestDTO songRequestDTO) {
        return songAdder.addSong(songRequestDTO);
    }

    public void deleteById(Long id) {
        songDeleter.deleteSong(id);
    }

    public void updateById(Long id, SongRequestDTO songRequestDTO) {
        songUpdater.updateById(id, songRequestDTO);
    }

    public SongDTO updatePartiallyById(Long id, SongRequestDTO songRequestDTO) {
        return songUpdater.updatePartiallyById(id, songRequestDTO);
    }

    public Set<ArtistDTO> findAllArtists() {
        return artistRetriever.findAllArtists();
    }

    public ArtistDTO addArtist(ArtistRequestDTO artistRequestDTO) {
        return artistAdder.addArtist(artistRequestDTO);
    }

    public GenreDTO addGenre(GenreRequestDTO genreRequestDTO) {
        return genreAdder.addGenre(genreRequestDTO);
    }

    public AlbumDTO addAlbum(AlbumRequestDTO albumRequestDTO) {
        return albumAdder.addAlbum(albumRequestDTO);
    }

}
