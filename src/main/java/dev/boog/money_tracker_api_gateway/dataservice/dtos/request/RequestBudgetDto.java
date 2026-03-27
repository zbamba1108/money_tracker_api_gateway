package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import lombok.*;
import lombok.experimental.*;
import lombok.extern.jackson.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestBudgetDto extends BaseRequestDto {
}
