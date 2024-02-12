package dev.aravind.Movies.Service;

import dev.aravind.Movies.Entity.Movie;
import dev.aravind.Movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repo;

    public List<Movie> getMovies(){
        return repo.findAll();
    }
public Optional<Movie> getById(String imdbId){
     return repo.getMovieByImdbId(imdbId);
}
    public Movie createMovie(Movie movie){
        return repo.save(movie);
    }
}
