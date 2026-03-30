package dev.boog.money_tracker_api_gateway.dataservice.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models.PageDto;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<E> {

    @JsonProperty(value = "data")
    private List<E> data;

    private PageDto page;
}
