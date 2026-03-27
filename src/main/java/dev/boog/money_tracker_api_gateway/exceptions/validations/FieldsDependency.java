package dev.boog.money_tracker_api_gateway.exceptions.validations;

import jakarta.validation.*;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsDependencyValidator.class)
@Repeatable(value = FieldsDependencies.class)
public @interface FieldsDependency {

    String message() default "Invalid field combination";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    String dependsOn();
}
