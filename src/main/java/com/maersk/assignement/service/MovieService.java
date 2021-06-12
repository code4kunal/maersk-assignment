package com.maersk.assignement.service;

import com.maersk.assignement.exception.ResourceNotFoundException;
import com.maersk.assignement.persistence.POJO.NewMovie;
import com.maersk.assignement.persistence.dao.MovieDAO;
import com.maersk.assignement.persistence.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDAO movieDAO;

    /**
     * Method to create new movie record based on user inputs
     * @param addMovie
     * @return
     */
    public MovieEntity createMovie(NewMovie addMovie) {
        MovieUtilService.validateYears(addMovie.getYear());
        MovieUtilService.validateRatings(addMovie.getRating());
        MovieEntity movieEntity = MovieEntity.builder()
                .name(addMovie.getName())
                .rating(addMovie.getRating())
                .year(addMovie.getYear())
                .build();
        return movieDAO.save(movieEntity);
    }

    /**
     * Method to update existing movie records based on user inputs
     * @param movieID
     * @param updateMovie
     * @return
     */
    public MovieEntity updateUser(Integer movieID, NewMovie updateMovie) {
        MovieEntity movieEntity = movieDAO.findById(movieID)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found for id : " +movieID,
                        HttpStatus.NOT_FOUND));
        MovieUtilService.validateYears(updateMovie.getYear());
        MovieUtilService.validateRatings(updateMovie.getRating());

        movieEntity.setName(updateMovie.getName());
        movieEntity.setRating(updateMovie.getRating());
        movieEntity.setYear(updateMovie.getYear());

        return movieDAO.save(movieEntity);
    }

    /**
     *  Method to fetch movie records based on input parameters like rating
     *  and year. If both are not supplied all records are returned.
     * @param rating
     * @param year
     * @return
     */
    public List<MovieEntity> getMovies(String rating, String year) {

        if(rating==null && year ==null){
            return movieDAO.findAll();
        }

        MovieEntity searchEntity =  MovieEntity.builder()
                .rating(rating)
                .year(year)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withIncludeNullValues();

        Example<MovieEntity> example = Example.of(searchEntity, matcher);
        List<MovieEntity> movieEntities = movieDAO.findAll(example);
        return movieEntities;
    }
}
