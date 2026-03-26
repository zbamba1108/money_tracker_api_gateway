package dev.boog.money_tracker_api_gateway.dataservice.dtos.response;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

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
