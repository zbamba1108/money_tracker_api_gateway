package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import dev.boog.money_tracker_api_gateway.exceptions.validations.Update;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Write;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestWalletDto extends BaseRequestDto {

    @NotBlank(groups = {Write.class, Update.class})
    private final String name;
}
