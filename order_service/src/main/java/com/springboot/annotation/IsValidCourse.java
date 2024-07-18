package com.springboot.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CourseTypeValidator.class)
public @interface IsValidCourse {

    String message () default "Not a valid course";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
