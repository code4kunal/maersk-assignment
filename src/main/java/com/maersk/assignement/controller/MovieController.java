package com.maersk.assignement.controller;

import com.maersk.assignement.persistence.POJO.NewMovie;
import com.maersk.assignement.persistence.entity.MovieEntity;
import com.maersk.assignement.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @ApiOperation(value = "create new movie record")
    @PostMapping("/movie")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody NewMovie addMovieRequest,
                                                HttpServletRequest httpServletRequest){

        MovieEntity newMovie = movieService.createMovie(addMovieRequest, httpServletRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }

    @ApiOperation(value = "update existing movie record")
    @PutMapping("/movie/{movieID}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "movieID") Long movieID,
                                             @Valid @RequestBody NewMovie addUserRequest,
                                             HttpServletRequest httpServletRequest){

        MovieEntity updatedMovie = movieService.updateUser(Math.toIntExact(movieID), addUserRequest, httpServletRequest);
        return ResponseEntity.ok(updatedMovie);
    }

    @ApiOperation(value = "get all movies")
    @GetMapping("/movies")
    public ResponseEntity<Object> getMovies(@RequestParam(required = false) String rating,
                                            @RequestParam(required = false) String year){

        List<MovieEntity> user = movieService.getMovies(rating, year);
        return ResponseEntity.ok(user);
    }

}
