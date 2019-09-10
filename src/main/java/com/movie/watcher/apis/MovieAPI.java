package com.movie.watcher.apis;

import com.movie.watcher.controller.MovieController;
import com.movie.watcher.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieAPI {

    private final MovieController movieController;
    @Autowired
    public MovieAPI(MovieController movieController) {
        this.movieController = movieController;
    }

    @RequestMapping("/movies")
    public List<Movie> searchMoviesByTitle(@RequestParam(name = "title") String title) {
        return movieController.searchMoviesByTitle(title);
    }

    @RequestMapping("/movies")
    public List<Movie> searchNextPage(@RequestParam(value = "title") String title, @RequestParam(value = "page") Integer page) {
        return movieController.getNextPage(title, page);
    }

    @PostMapping("/movies/")
    public List<Movie> addMovie(@RequestBody Movie movie) {
        movieController.addMovie(movie);
        return movieController.getAllMovies();
    }

    @RequestMapping("/movie/{id}")
    @ResponseBody
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieController.getMovieById(id);
    }

    @RequestMapping("/movies/count")
    public Integer getResponseCount(@RequestParam(name = "title") String title) {
        return movieController.getMovieCount(title);
    }
}
