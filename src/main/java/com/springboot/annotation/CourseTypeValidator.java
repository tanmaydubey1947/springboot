package com.springboot.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CourseTypeValidator implements ConstraintValidator<IsValidCourse, String> {
    @Override
    public boolean isValid(String courseType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> courseTypes = Arrays.asList("LIVE", "RECORDING");
        return courseTypes.contains(courseType);
    }
}
