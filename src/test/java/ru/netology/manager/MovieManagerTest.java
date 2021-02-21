package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager movieManager = new MovieManager();

    private Movie[] movies;

    @Test
    public void shouldAddMovies() {
        movies = new Movie[3];

        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManager.add(movies[i]);
        }

        Movie[] actual = movieManager.getPoster();
        Movie[] expected = new Movie[]{movies[2], movies[1], movies[0]};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetLessThanTenMovies() {
        movies = new Movie[5];

        for (int i = 0; i < 5; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 5; i++) {
            movieManager.add(movies[i]);
        }

        Movie[] actual = movieManager.getMovies();
        Movie[] expected = new Movie[]{movies[4], movies[3], movies[2], movies[1], movies[0]};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetTenMoviesThenMore() {
        movies = new Movie[11];

        for (int i = 0; i < 11; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 11; i++) {
            movieManager.add(movies[i]);
        }

        Movie[] actual = movieManager.getMovies();
        Movie[] expected = new Movie[10];
        for (int i = 0; i < 10; i++) {
            expected[i] = movies[10 - i];
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesWhenNumToShowMore() {
        MovieManager movieManagerWithSetup = new MovieManager(6);
        movies = new Movie[3];

        for (int i = 0; i < 3; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 3; i++) {
            movieManagerWithSetup.add(movies[i]);
        }

        Movie[] actual = movieManagerWithSetup.getMovies();
        Movie[] expected = new Movie[3];
        for (int i = 0; i < 3; i++) {
            expected[i] = movies[2 - i];
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesWhenNumToShowLess() {
        MovieManager movieManagerWithSetup = new MovieManager(6);
        movies = new Movie[10];

        for (int i = 0; i < 10; i++) {
            movies[i] = new Movie();
        }
        for (int i = 0; i < 10; i++) {
            movieManagerWithSetup.add(movies[i]);
        }

        Movie[] actual = movieManagerWithSetup.getMovies();
        Movie[] expected = new Movie[6];
        for (int i = 0; i < 6; i++) {
            expected[i] = movies[6 - i];
        }

        assertArrayEquals(expected, actual);
    }

}