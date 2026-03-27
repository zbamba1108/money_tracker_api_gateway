package dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models;

import lombok.*;
import lombok.experimental.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {

    private Long id;

    private Long createdAt;

}
