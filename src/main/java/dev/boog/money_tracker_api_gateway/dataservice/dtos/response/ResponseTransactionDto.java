package dev.boog.money_tracker_api_gateway.dataservice.dtos.response;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models.*;
import java.math.*;
import lombok.*;
import lombok.experimental.*;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTransactionDto extends BaseDto {

    private ResponseWalletDto wallet;

    private ResponseCategoryDto category;

    private BigDecimal amount;

    private String comment;
}
