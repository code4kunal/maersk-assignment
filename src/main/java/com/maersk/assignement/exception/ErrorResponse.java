package com.maersk.assignement.exception;

import com.maersk.assignement.constant.ErrorMessage;
import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse
{
    public ErrorResponse(ErrorMessage message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    //General error message about nature of error
    private ErrorMessage message;

    //Specific errors in API request processing
    private List<String> details;
}