package org.example.songify.domain.crud;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class InMemoryGenreRepository implements GenreRepository {
    Map<Long, Genre> db = new HashMap<>();

    InMemoryGenreRepository() {
        db.put(1L, new Genre(1L, "default"));
    }

    @Override
    public Optional<Genre> findById(final Long id) {
        Genre genre = db.get(id);
        return Optional.ofNullable(genre);
    }

    @Override
    public void deleteById(final Long id) {

    }

    @Override
    public Genre save(final Genre genre) {
        return null;
    }

    @Override
    public boolean existsById(final Long id) {
        return false;
    }
}
