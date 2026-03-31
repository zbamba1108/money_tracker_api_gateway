package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import dev.boog.money_tracker_api_gateway.exceptions.validations.Read;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Update;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Write;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestTransactionDto extends BaseRequestDto {

    @Min(value = 1, groups = {Write.class, Read.class, Update.class})
    @NotNull(groups = Write.class)
    private final Long walletId;

    @Min(1)
    private final Long eventId;

    @Min(value = 1, groups = {Write.class, Read.class, Update.class})
    @NotNull(groups = Write.class)
    private final Long categoryId;

    @Positive(groups = {Write.class, Read.class, Update.class})
    private final BigDecimal amount;

    private final String comment;

}
