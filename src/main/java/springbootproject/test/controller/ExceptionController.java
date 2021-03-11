package springbootproject.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionController extends RuntimeException{ //ResponseEntityExceptionHandler {

    private static final long serialVersionUID = 1L;
    private Date timestamp;
    private String message;
    private String detail;

/*
    public ExceptionController(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }
*/

    @ExceptionHandler(value = ExceptionController.class)
    public ResponseEntity<Object> exception(ExceptionController exception) {
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }

/*
    @ExceptionHandler(value = ExceptionController.class)
    //override method of ResponseEntityExceptionHandler class
    public final ResponseEntity<Object> handleAllExceptions(ExceptionController ex, WebRequest request) {
        //creating exception response structure
        ExceptionController exceptionResponse = new ExceptionController(new Date(), ex.getMessage(), request.getDescription(false));
        //returning exception structure and specific status
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/
}
