package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import dev.boog.money_tracker_api_gateway.exceptions.validations.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;
import lombok.extern.jackson.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestWalletDto extends BaseRequestDto {

    @NotBlank(groups = Write.class)
    private final String name;
}
