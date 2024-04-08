package br.com.paulohonfi.ekan.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoSuchElementExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object>  noSuchElementException(final Exception exception) {
        return new ResponseEntity<>("Id não encontrado.", HttpStatus.NOT_FOUND);
    }
}
