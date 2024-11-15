package com.es.segurosinseguros.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {

    //  Todas las exceptions nativas que meta en exceptionHandler se convierte a mi mensahe de salida de BAD_REQUEST
    //  @ExceptionHandler({BadRequestException.class, IllegalAccessException.class, NumberFormatException.class})
    @ExceptionHandler({BadRequestException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody

    public ErrorMessageForClient handlerBadRequest(HttpServletRequest resquest, Exception e) {
        return new ErrorMessageForClient(e.getMessage(), resquest.getRequestURI());
    }
    // e.getMessage() -> BAD_REQUEST (400) + el mensaje personalizado en la excepcion
    // e.getMessage() -> BAD_REQUEST (400) + id no válido




}
