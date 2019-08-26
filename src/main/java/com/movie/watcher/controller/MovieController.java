package com.movie.watcher.controller;

import com.movie.watcher.model.Movie;
import com.movie.watcher.persistence.MovieDAO;
import com.movie.watcher.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieController {
    @Autowired
    private MovieDAO movieDAO;

    private OmdbService omdbService;

    public List<Movie> getAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        movieDAO.findAll().forEach(allMovies::add);
        return allMovies;
    }

    public void addMovie(Movie movie) {
        Movie persistedMovie = movieDAO.findByImdbID(movie.getImdbID());
        if (persistedMovie == null) {
            movieDAO.save(movie);
            }

        }

    public void addMovies(List<Movie> movieList) {
        
}
    public Movie getMovie(String id) {
        return movieDAO.findById(id).get();
    }

    public void updateMovie(String id, Movie movie) {
        movieDAO.save(movie);
    }

    public void deleteMovie(Movie movie) {
        movieDAO.delete(movie);
    }

    public Movie getMovieByImdbID(String movieID) {
        return movieDAO.findByImdbID(movieID);
    }

}

