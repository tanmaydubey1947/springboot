package com.springboot.handler;

import com.springboot.dto.ErrorDTO;
import com.springboot.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResponse<?> handleMethodArgumentException(MethodArgumentNotValidException argException) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOS = new ArrayList<>();
        argException.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorDTO errorDTO = new ErrorDTO(error.getDefaultMessage());
                    errorDTOS.add(errorDTO);
                });

        serviceResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        serviceResponse.setErrors(errorDTOS);
        return serviceResponse;
    }
}
