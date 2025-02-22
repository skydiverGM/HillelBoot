package imaks.hillelboot.controller;

import imaks.hillelboot.exception.OrderErrorResponse;
import imaks.hillelboot.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException exc){
        OrderErrorResponse error = new OrderErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
