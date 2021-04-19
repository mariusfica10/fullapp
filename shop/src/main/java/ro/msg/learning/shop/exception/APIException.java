package ro.msg.learning.shop.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class APIException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public APIException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp)
    {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage()
    {
        return this.message;
    }

    public Throwable getThrowable()
    {
        return this.throwable;
    }

    public HttpStatus getHttpStatus()
    {
        return this.httpStatus;
    }

    public ZonedDateTime getTimestamp()
    {
        return this.timestamp;
    }

}
