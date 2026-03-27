package dev.boog.money_tracker_api_gateway.dataservice.dtos.response;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models.*;
import lombok.*;
import lombok.experimental.*;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBudgetDto extends BaseDto {

    private String budget;
}
