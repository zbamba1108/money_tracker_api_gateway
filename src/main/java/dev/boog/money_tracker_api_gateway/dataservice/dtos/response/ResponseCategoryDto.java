package dev.boog.money_tracker_api_gateway.dataservice.dtos.response;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models.*;
import lombok.*;
import lombok.experimental.*;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategoryDto extends BaseDto {

    private String name;

    private Integer type;

    private Long parentId;
}
