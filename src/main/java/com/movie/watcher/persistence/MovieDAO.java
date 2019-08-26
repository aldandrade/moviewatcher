package com.movie.watcher.persistence;

import com.movie.watcher.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieDAO extends CrudRepository<Movie,String> {
    Movie findByImdbID(String imdbID);
    List<Movie> findByImdbIDIn(List ids);
}
