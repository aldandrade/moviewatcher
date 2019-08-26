package com.movie.watcher.apis;

import com.movie.watcher.controller.MovieController;
import com.movie.watcher.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MovieAPI {

    private final MovieController movieController;
    @Autowired
    public MovieAPI(MovieController movieController) {
        this.movieController = movieController;
    }



    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieController.getAllMovies();
    }
}
