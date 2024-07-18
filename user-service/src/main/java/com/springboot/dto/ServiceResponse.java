package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {

    private HttpStatus httpStatus;
    private T response;
    private List<ErrorDTO> errors;

    public ServiceResponse(HttpStatus httpStatus, T response) {
        this.httpStatus = httpStatus;
        this.response = response;
    }
}