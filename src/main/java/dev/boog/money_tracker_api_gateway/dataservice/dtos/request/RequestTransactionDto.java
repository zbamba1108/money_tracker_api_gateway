package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import dev.boog.money_tracker_api_gateway.exceptions.validations.*;
import jakarta.validation.constraints.*;
import java.math.*;
import lombok.*;
import lombok.experimental.*;
import lombok.extern.jackson.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestTransactionDto extends BaseRequestDto {

    @Min(value = 1, groups = {Write.class, Read.class})
    @NotNull(groups = Write.class)
    private final Long walletId;

    @Min(1)
    private final Long eventId;

    @Min(value = 1, groups = {Write.class, Read.class})
    @NotNull(groups = Write.class)
    private final Long categoryId;

    @Positive(groups = {Write.class, Read.class})
    private final BigDecimal amount;

    private final String comment;

}
