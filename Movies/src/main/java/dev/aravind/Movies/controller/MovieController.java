package dev.aravind.Movies.controller;

import dev.aravind.Movies.Entity.Movie;
import dev.aravind.Movies.Service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private MovieService service;

   @GetMapping("/getAllMovies")

    public ResponseEntity<List<Movie>> getAllMovies(){
       return new ResponseEntity<List<Movie>>(service.getMovies(),HttpStatus.OK);
   }

   @GetMapping("/{imdbId}")
   public Optional<Movie> getMovieById(@PathVariable String imdbId){
       logger.info("getbyId");
       return service.getById(imdbId);
   }

   @PostMapping("/post")
    public Movie createMovie(@RequestBody Movie movie){

       return service.createMovie(movie);
   }
}
