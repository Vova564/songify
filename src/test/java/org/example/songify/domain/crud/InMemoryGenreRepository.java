package org.example.songify.domain.crud;

class InMemoryGenreRepository implements GenreRepository {
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
