package com.springboot.handler;

import com.springboot.dto.ErrorDTO;
import com.springboot.dto.ServiceResponse;
import com.springboot.exception.UserServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
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


    @ExceptionHandler(UserServiceException.class)
    public ServiceResponse<?> handleUserServiceException(UserServiceException userServiceException) {

        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDTO> errorDTOS = new ArrayList<>();
        errorDTOS.add(new ErrorDTO(userServiceException.getMessage()));
        serviceResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        serviceResponse.setErrors(errorDTOS);
        return serviceResponse;
    }
}
