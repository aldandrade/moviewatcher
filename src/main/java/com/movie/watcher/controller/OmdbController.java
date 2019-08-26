package com.movie.watcher.controller;

import com.movie.watcher.model.Movie;
import com.movie.watcher.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class OmdbController {

    private OmdbService omdbService;

    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

    @RequestMapping("/hello/omdb")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Movie> getAllMovies(@RequestParam String title){
        return omdbService.getMovies(title);
    }
}
