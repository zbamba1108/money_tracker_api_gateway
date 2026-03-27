package dev.boog.money_tracker_api_gateway.exceptions.validations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsDependencies {

    FieldsDependency[] value();
}
