package cl.lgutierrez.example.app.infraestructure.controller.exception;

import cl.lgutierrez.example.app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleError(RuntimeException ex) {
    return new ResponseEntity<>(new ErrorResponse().message(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
