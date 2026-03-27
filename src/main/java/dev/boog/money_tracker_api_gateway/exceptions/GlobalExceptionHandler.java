package dev.boog.money_tracker_api_gateway.exceptions;

import java.util.logging.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleArgumentNotValid(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex
                        .getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(e -> new ValidationFields(e.getField(), e.getDefaultMessage()))
                        .toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
