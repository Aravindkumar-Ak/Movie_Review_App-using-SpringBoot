package dev.aravind.Movies.controller;
import dev.aravind.Movies.Entity.Review;
import dev.aravind.Movies.Service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")


public class ReviewController {
    @Autowired
   private ReviewService service ;

    private Logger log= LoggerFactory.getLogger(getClass());


    @PostMapping()

    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
log.info("review created");
        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);
    }
}
