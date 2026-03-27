package dev.boog.money_tracker_api_gateway.dataservice.dtos.request;


import dev.boog.money_tracker_api_gateway.exceptions.validations.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.*;
import lombok.extern.jackson.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@SuperBuilder
@Jacksonized
public class RequestCategoryDto extends BaseRequestDto {

    @NotBlank(groups = Write.class)
    private final String name;

    @Min(value = 0, groups = {Write.class, Read.class})
    @Max(value = 1, groups = {Write.class, Read.class})
    @NotNull(groups = Write.class)
    private final Integer type;

    @Min(value = 1, groups = {Write.class, Read.class})
    private final Long parentId;
}
