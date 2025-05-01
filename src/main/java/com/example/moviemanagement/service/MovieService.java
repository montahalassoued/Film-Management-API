package com.example.moviemanagement.service;

import com.example.moviemanagement.model.Movie;
import com.example.moviemanagement.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    public MovieRepository movieRepository;
    public Movie addMovie(Movie movie) {
        try {
            if (movie.getId() != null) {
                throw new IllegalArgumentException("ID should not be provided when creating a new movie.");
            }
            return movieRepository.save(movie);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding movie: " + e.getMessage());
        }
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void deleteMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title);
        if (movie != null) {
            movieRepository.delete(movie);
        }
    }
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }


}
