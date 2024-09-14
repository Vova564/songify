package org.example.songify.domain.crud;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.songify.domain.crud.dto.ArtistDTO;
import org.example.songify.domain.crud.dto.SongDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.songify.domain.crud.SongifyDomainMapper.mapFromArtistDTOToArtist;
import static org.example.songify.domain.crud.SongifyDomainMapper.mapFromArtistToArtistDTO;
import static org.example.songify.domain.crud.SongifyDomainMapper.mapFromSongDTOToSong;
import static org.example.songify.domain.crud.SongifyDomainMapper.mapFromSongToSongDTO;

@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SongifyCrudFacade {

    private final SongRetriever songRetriever;
    private final SongAdder songAdder;
    private final SongDeleter songDeleter;
    private final SongUpdater songUpdater;
    private final ArtistAdder artistAdder;

    public List<SongDTO> findAll(final Pageable pageable) {
        return songRetriever.findAll(pageable)
                .stream()
                .map(SongifyDomainMapper::mapFromSongToSongDTO)
                .toList();
    }

    public SongDTO findSongById(Long id) {
        Song song = songRetriever.findSongById(id);
        return mapFromSongToSongDTO(song);
    }

    public SongDTO addSong(SongDTO songDTO) {
        Song songValidatedAndReadyToSave = mapFromSongDTOToSong(songDTO);
        Song addedSong = songAdder.addSong(songValidatedAndReadyToSave);
        return mapFromSongToSongDTO(addedSong);
    }

    public void deleteById(Long id) {
        songRetriever.existsById(id);
        songDeleter.deleteSong(id);
    }

    public void updateById(Long id, SongDTO newSongDTO) {
        songRetriever.existsById(id);

        Song songValidatedAndReadyToUpdate = mapFromSongDTOToSong(newSongDTO);
        songUpdater.updateById(id, songValidatedAndReadyToUpdate);
    }

    public SongDTO updatePartiallyById(Long id, SongDTO newSongDTO) {
        songRetriever.existsById(id);

        Song songFromDatabase = songRetriever.findSongById(id);
        Song songValidatedAndReadyToUpdate = mapFromSongDTOToSong(newSongDTO);
        Song updatedSong = songUpdater.updatePartiallyById(id, songValidatedAndReadyToUpdate, songFromDatabase);

        return mapFromSongToSongDTO(updatedSong);
    }

    public ArtistDTO addArtist(ArtistDTO artistDTO) {
        Artist artistValidatedAndReadyToSave = mapFromArtistDTOToArtist(artistDTO);
        Artist addedArtist = artistAdder.addArtist(artistValidatedAndReadyToSave);
        return mapFromArtistToArtistDTO(addedArtist);
    }

}
