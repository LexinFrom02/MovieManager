package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private int moviesToShowInPoster = 10;

    private Movie[] movies = new Movie[0];

    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] getPoster() {
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getMovies() {
        int numToShow = Math.min(movies.length, moviesToShowInPoster);
        Movie[] result = new Movie[numToShow];

        for (int i = 0; i < result.length; i++) {
            int index = numToShow - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public MovieManager() {
    }

    public MovieManager(int numOfMoviesToShow) {
        this.moviesToShowInPoster = numOfMoviesToShow;
    }
}