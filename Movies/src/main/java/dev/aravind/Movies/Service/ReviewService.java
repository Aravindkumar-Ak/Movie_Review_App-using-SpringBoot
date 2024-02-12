package dev.aravind.Movies.Service;

import dev.aravind.Movies.Entity.Movie;
import dev.aravind.Movies.Repository.ReviewRepository;

import dev.aravind.Movies.Entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Review createReview(String reviewBody, String imdbId){
        Review review=repository.insert(new Review(reviewBody));
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();
        return  review;
    }
}
