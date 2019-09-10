package com.movie.watcher.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String imdbID; //imdbID that came from the OMDB API
    @NotBlank
    private String Title;
    private String Year;
    @NotBlank
    private String Type;
    private String Poster;
    private boolean isFavorite;



    public Movie() {
    }

    public Movie(Long id, String imdbID, String Title, String Year, String type, String posterLink, Boolean isFavorite) {
        super();
        this.id = id;
        this.imdbID = imdbID;
        this.Title = Title;
        this.Year = Year;
        this.Type = type;
        this.Poster = posterLink;
        this.isFavorite = isFavorite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setImdbID(String id) {
        this.imdbID = imdbID;
    }

    public String getImdbID() {
        return this.imdbID;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getPosterLink() {
        return Poster;
    }

    public void setPosterLink(String posterLink) {
        this.Poster = posterLink;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }
}

