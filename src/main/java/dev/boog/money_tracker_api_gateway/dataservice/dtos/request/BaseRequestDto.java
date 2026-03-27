package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;

import dev.boog.money_tracker_api_gateway.dataservice.utils.*;
import dev.boog.money_tracker_api_gateway.dataservice.utils.enums.*;
import dev.boog.money_tracker_api_gateway.exceptions.validations.*;
import jakarta.validation.constraints.*;
import java.util.*;
import lombok.*;
import lombok.experimental.*;
import lombok.extern.jackson.*;

@Getter
@SuperBuilder
@Jacksonized
@FieldsDependency(fieldName = "startDate", dependsOn = "endDate", groups = Read.class)
@FieldsDependency(fieldName = "endDate", dependsOn = "startDate", groups = Read.class)
public class BaseRequestDto {

    @Size(min = 1, max = 10, groups = {Read.class})
    private final List<Long> ids;

    @NotNull(groups = Read.class)
    @Builder.Default
    private final Integer page = 0;

    @NotNull(message = "pageSize cannot be null",  groups = Read.class)
    @Min(value = 1, message = "pageSize cannot be less than 1",  groups = Read.class)
    @Builder.Default
    private final Integer pageSize = 5;

    @Positive(groups = Read.class)
    private final Long startDate;

    @Positive(groups = Read.class)
    private final Long endDate;

    @NotBlank(groups = {Read.class})
    @Builder.Default
    private final String sortingField = Constants.Fields.ID;

    @Builder.Default
    private final SortingOrder sortingOrder = SortingOrder.ASC;

}
