package dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {

    private Long id;

    private Long createdAt;

}
