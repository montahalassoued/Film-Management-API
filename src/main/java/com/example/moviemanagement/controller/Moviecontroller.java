package com.example.moviemanagement.controller;

import com.example.moviemanagement.model.Movie;
import com.example.moviemanagement.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/movies")
public class Moviecontroller {
    final private MovieService movieService;
    public Moviecontroller(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        System.out.println("Received movie: " + movie);
         return movieService.addMovie(movie);
    }

    @DeleteMapping("/{title}")
    public void deleteMovie(@PathVariable String title) {
        movieService.deleteMovieByTitle(title);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/director/{director}")
    public List<Movie> getMoviesByDirector(@PathVariable String director) {
        return movieService.getMoviesByDirector(director);
    }

}
