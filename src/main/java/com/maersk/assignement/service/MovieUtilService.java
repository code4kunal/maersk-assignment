package com.maersk.assignement.service;

import com.maersk.assignement.constant.MovieRating;
import com.maersk.assignement.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class MovieUtilService {
    /**
     * Method to Validate year while creating/updating movie record.
     * @param year
     */
    public static void validateYears(String year) {
        Integer yearAsInt  = Integer.parseInt(year);
        if(yearAsInt <=0 || yearAsInt > LocalDateTime.now().getYear()){
            throw new BadRequestException("Invalid year : " +year, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *  Method to validate ratings value, ratings have strict value
     *  specified in movierating enum.
     * @param rating
     */
    public static void validateRatings(String rating) {
        try {
            MovieRating.valueOf(rating);
        } catch(Exception ex){
            throw new BadRequestException("Invalid rating : " +rating, HttpStatus.BAD_REQUEST);
        }
    }


}
