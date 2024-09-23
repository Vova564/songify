package org.example.songify.domain.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.songify.domain.crud.util.BaseEntity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor
class Album extends BaseEntity {

    @Id
    @GeneratedValue(generator = "album_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    private Instant releaseDate;

    @OneToMany
    @JoinColumn(name = "album_id")
    private Set<Song> songs = new HashSet<>();

    @ManyToMany(mappedBy = "albums")
    private Set<Artist> artists = new HashSet<>();

    Album(final String name, final Instant releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    void addSong(final Song song) {
        this.songs.add(song);
    }

    void removeArtist(Artist artist) {
        artists.remove(artist);
        artist.removeAlbum(this);
    }
}
