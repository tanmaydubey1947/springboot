package com.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseDTO {

    private String name;
    private String duration;
    @Description(value = "LIVE or RECORDING")
    private String type;
    private double fees;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

}
