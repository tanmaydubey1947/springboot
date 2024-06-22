package com.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.annotation.IsValidCourse;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String duration;
    @Description(value = "LIVE or RECORDING")
    @IsValidCourse
    private String type;
    @Min(value = 1000, message = "Fees can't be less than 1000")
    @Max(value = 8000, message = "Fees can't exceed more than 8000")
    private double fees;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

}
