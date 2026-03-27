package dev.boog.money_tracker_api_gateway.dataservice.dtos.response.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {

    private Long records;

    private boolean hasNext;
}
