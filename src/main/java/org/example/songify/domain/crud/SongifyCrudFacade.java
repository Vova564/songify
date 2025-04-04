package org.example.songify.domain.crud;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.AlbumDTO;
import org.example.songify.domain.crud.dto.AlbumRequestDTO;
import org.example.songify.domain.crud.dto.AlbumWithArtistsAndSongsDTO;
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
@Transactional
public class SongifyCrudFacade {

    private final SongRetriever songRetriever;
    private final SongAdder songAdder;
    private final SongDeleter songDeleter;
    private final SongUpdater songUpdater;
    private final ArtistAdder artistAdder;
    private final ArtistRetriever artistRetriever;
    private final ArtistDeleter artistDeleter;
    private ArtistUpdater artistUpdater;
    private final ArtistAssigner artistAssigner;
    private final GenreRetriever genreRetriever;
    private final GenreAdder genreAdder;
    private final AlbumAdder albumAdder;
    private final AlbumRetriever albumRetriever;

    public List<SongDTO> findAllSongs(Pageable pageable) {
        return songRetriever.findAllSongs(pageable);
    }

    public SongDTO findSongById(Long songId) {
        return songRetriever.findSongById(songId);
    }

    public SongDTO addSong(SongRequestDTO songRequestDTO) {
        return songAdder.addSong(songRequestDTO);
    }

    public void deleteSongById(Long songId) {
        songDeleter.deleteById(songId);
    }

    // Deleting song with cascade genre remover //
//    public void deleteSongAndGenreById(Long id) {
//        songDeleter.deleteSongAndGenreById(id);
//    }

    public void updateSongById(Long songId, SongRequestDTO songRequestDTO) {
        songUpdater.updateSongById(songId, songRequestDTO);
    }

    public void updateSongGenre(Long songId, Long genreId) {
        songUpdater.updateSongGenre(songId, genreId);
    }

    public SongDTO updateSongPartiallyById(Long songId, SongRequestDTO songRequestDTO) {
        return songUpdater.updateSongPartiallyById(songId, songRequestDTO);
    }

    public Set<ArtistDTO> findAllArtists(Pageable pageable) {
        return artistRetriever.findAllArtists(pageable);
    }

    ArtistDTO findArtistById(Long id) {
        return artistRetriever.findArtistById(id);
    }

    public ArtistDTO addArtist(ArtistRequestDTO artistRequestDTO) {
        return artistAdder.addArtist(artistRequestDTO);
    }

    public void addArtistToAlbum(Long artistId, Long albumId) {
        artistAssigner.addArtistToAlbum(artistId, albumId);
    }

    public ArtistDTO addArtistWithDefaultAlbumAndSong(ArtistRequestDTO artistRequestDTO) {
        return artistAdder.addArtistWithDefaultAlbumAndSong(artistRequestDTO);
    }

    public void deleteArtistByIdWithAlbumsAndSongs(Long artistId) {
        artistDeleter.deleteArtistByIdWithAlbumsAndSongs(artistId);
    }

    public void updateArtistNameById(Long id, String name) {
        artistUpdater.updateArtistNameById(id, name);
    }

    public Set<GenreDTO> findAllGenres() {
        return genreRetriever.findAllGenres();
    }

    public GenreDTO addGenre(GenreRequestDTO genreRequestDTO) {
        return genreAdder.addGenre(genreRequestDTO);
    }

    public Set<AlbumDTO> findAllAlbums() {
        return albumRetriever.findAllAlbums();
    }

    public AlbumDTO findAlbumById(Long id) {
        return albumRetriever.findAlbumById(id);
    }

    public AlbumWithArtistsAndSongsDTO findAlbumByIdWithArtistsAndSongs(Long albumId) {
        return albumRetriever.findAlbumByIdWithArtistsAndSongs(albumId);
    }

    public Set<AlbumDTO> findAlbumsByArtistId(Long artistId) {
        return albumRetriever.findAlbumsByArtistIdReturnAlbumDTO(artistId);
    }

    public AlbumDTO addAlbumWithSong(AlbumRequestDTO albumRequestDTO) {
        return albumAdder.addAlbumWithSong(albumRequestDTO);
    }

}
