package com.movie.watcher.controller;

import com.movie.watcher.model.Movie;
import com.movie.watcher.persistence.MovieDAO;
import com.movie.watcher.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("MovieController")
public class MovieController {

    private final MovieDAO movieDAO;
    private final OmdbService omdbService;


    @Autowired
    public MovieController(MovieDAO movieDAO, OmdbService omdbService) {
        this.movieDAO = movieDAO;
        this.omdbService = omdbService;
    }

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

    public List<Movie> searchMoviesByTitle(String id) {
        List<Movie> movieList = omdbService.getMovies(id);
        for (Movie mov : movieList
        ) {
            Movie persistedMovie = movieDAO.findByImdbID(mov.getImdbID());
            if (persistedMovie == null) {
                movieDAO.save(mov);
            }
        }
        return movieList;
    }

    public int getMovieCount(String title) {
        Integer totalMovies = omdbService.getMovieCount(title);
        return totalMovies;
    }

    public List<Movie> getNextPage(String id, Integer page) {
        List<Movie> movieList = omdbService.getNextPage(id, page);
        for (Movie mov : movieList
        ) {
            Movie persistedMovie = movieDAO.findByImdbID(mov.getImdbID());
            if (persistedMovie == null) {
                movieDAO.save(mov);
            }
        }
        return movieList;
    }

    public void updateMovie(String id, Movie movie) {
        movieDAO.save(movie);
    }

    public void deleteMovie(Movie movie) {
        movieDAO.delete(movie);
    }

    public Optional<Movie> getMovieById(Long movieID) {
        return movieDAO.findById(movieID);
    }

}

