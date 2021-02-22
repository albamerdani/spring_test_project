package springboot_project.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springboot_project.test.model.Punonjes;

@ControllerAdvice
public class ExceptionController extends RuntimeException{

    private static final long serialVersionUID = 1L;

    @ExceptionHandler(value = ExceptionController.class)
    public ResponseEntity<Object> exception(ExceptionController exception) {
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }

}
