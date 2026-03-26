package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestEventDto extends BaseRequestDto {
}
