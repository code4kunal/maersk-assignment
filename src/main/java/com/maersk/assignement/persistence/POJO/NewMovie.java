package com.maersk.assignement.persistence.POJO;

import com.maersk.assignement.constant.MovieRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class NewMovie {

    @NotEmpty(message = "movie name must not be empty")
    private String name;
    @NotEmpty(message = "rating must not be empty")
    private String rating;
    private String year;
}
