package ro.msg.learning.shop.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    
    @ExceptionHandler(value = {APIRequestException.class} )
    public ResponseEntity<Object> handleAPIRequestException(APIRequestException e)
    {
        //create payload containing excepiton details
        APIException z = new APIException(
            e.getMessage(),
            e,
            HttpStatus.BAD_REQUEST,
            ZonedDateTime.now(ZoneId.of("Z"))
        );
        // return the actual respone entity
        return new ResponseEntity<>(z, HttpStatus.BAD_REQUEST);

    }
}
