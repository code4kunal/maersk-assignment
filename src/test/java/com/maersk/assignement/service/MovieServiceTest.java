package com.maersk.assignement.service;

import com.maersk.assignement.exception.BadRequestException;
import com.maersk.assignement.persistence.POJO.NewMovie;
import com.maersk.assignement.persistence.dao.MovieDAO;
import com.maersk.assignement.persistence.entity.MovieEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieDAO movieDAO;

    @InjectMocks
    private MovieService movieService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenCreateMovieRecord_whenValidRequest_thenSaveAndReturnEntity(){

       NewMovie newMovie =  NewMovie.builder()
               .name("DDLJ")
               .rating("HIT")
               .year("1999")
               .build();
       MovieEntity expected = MovieEntity.builder()
                .name("DDLJ")
                .rating("HIT")
                .year("1999")
                .build();
       Mockito.when(movieDAO.save(any())).thenReturn(expected);
       MovieEntity actual = movieService.createMovie(newMovie);
       Assert.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void givenCreateMovieRecord_wheninValidRating_thenThrowException(){

        NewMovie newMovie =  NewMovie.builder()
                .name("DDLJ")
                .rating("BLOCK")
                .year("1999")
                .build();
        MovieEntity expected = MovieEntity.builder()
                .build();
        Mockito.when(movieDAO.save(any())).thenReturn(expected);
        exceptionRule.expect(BadRequestException.class);

        MovieEntity actual = movieService.createMovie(newMovie);

    }

    @Test
    public void givenCreateMovieRecord_wheninValidYear_thenThrowException(){

        NewMovie newMovie =  NewMovie.builder()
                .name("DDLJ")
                .rating("BLOCK")
                .year("2048")
                .build();
        MovieEntity expected = MovieEntity.builder()
                .build();
        Mockito.when(movieDAO.save(any())).thenReturn(expected);
        exceptionRule.expect(BadRequestException.class);

        MovieEntity actual = movieService.createMovie(newMovie);

    }

    @Test
    public void givenCreateMovieRecord_whenEmptyYearAndRating_thenThrowException(){

        NewMovie newMovie =  NewMovie.builder()
                .name("DDLJ")
                .rating("")
                .year("")
                .build();
        MovieEntity expected = MovieEntity.builder()
                .build();
        Mockito.when(movieDAO.save(any())).thenReturn(expected);
        exceptionRule.expect(BadRequestException.class);

        MovieEntity actual = movieService.createMovie(newMovie);

    }

    @Test
    public void givenUpdateMovieRecord_whenValidRequest_thenUpdateAndReturnEntity(){

        NewMovie updateMovie =  NewMovie.builder()
                .name("DDLJ")
                .rating("HIT")
                .year("1999")
                .build();
        MovieEntity expected = MovieEntity.builder()
                .name("DDLJ")
                .rating("HIT")
                .year("1999")
                .build();
        MovieEntity existing = MovieEntity.builder()
                .name("MMNK")
                .rating("FLOP")
                .year("2019")
                .build();
        Mockito.when(movieDAO.findById(any())).thenReturn(java.util.Optional.ofNullable(existing));
        Mockito.when(movieDAO.save(any())).thenReturn(expected);
        MovieEntity actual = movieService.createMovie(updateMovie);
        Assert.assertEquals(expected.getName(), actual.getName());
    }
}