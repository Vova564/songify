package org.example.songify.domain.crud;

import org.springframework.context.annotation.Configuration;

@Configuration
class SongifyCrudFacadeConfiguration {
    public static SongifyCrudFacade createSongifyCrud(final SongRepository songRepository,
                                                      final GenreRepository genreRepository,
                                                      final ArtistRepository artistRepository,
                                                      final AlbumRepository albumRepository) {

        SongifyDomainMapper songifyDomainMapper = new SongifyDomainMapper();
        SongRetriever songRetriever = new SongRetriever(songRepository, songifyDomainMapper);
        GenreRetriever genreRetriever = new GenreRetriever(genreRepository, songifyDomainMapper);
        GenreAssigner genreAssigner = new GenreAssigner(songRetriever, genreRetriever);
        SongAdder songAdder = new SongAdder(songRepository, songifyDomainMapper, genreAssigner);
        GenreDeleter genreDeleter = new GenreDeleter(genreRepository, genreRetriever);
        SongDeleter songDeleter = new SongDeleter(songRepository, songRetriever, genreDeleter);
        SongUpdater songUpdater = new SongUpdater(songRepository, songifyDomainMapper, songRetriever);
        GenreAdder genreAdder = new GenreAdder(genreRepository, songifyDomainMapper);
        AlbumRetriever albumRetriever = new AlbumRetriever(albumRepository, songifyDomainMapper);
        AlbumAdder albumAdder = new AlbumAdder(albumRepository, songifyDomainMapper, songRetriever);
        AlbumDeleter albumDeleter = new AlbumDeleter(albumRepository);
        ArtistRetriever artistRetriever = new ArtistRetriever(artistRepository, songifyDomainMapper);
        ArtistAdder artistAdder = new ArtistAdder(artistRepository, songifyDomainMapper, albumAdder, songAdder);
        ArtistDeleter artistDeleter = new ArtistDeleter(artistRepository, artistRetriever, albumRetriever, albumDeleter, songDeleter);
        ArtistAssigner artistAssigner = new ArtistAssigner(artistRetriever, albumRetriever);
        ArtistUpdater artistUpdater = new ArtistUpdater(artistRepository, artistRetriever);

        return new SongifyCrudFacade(
                songRetriever,
                songAdder,
                songDeleter,
                songUpdater,
                artistAdder,
                artistRetriever,
                artistDeleter,
                artistUpdater,
                artistAssigner,
                genreRetriever,
                genreAdder,
                albumAdder,
                albumRetriever
        );
    }
}
