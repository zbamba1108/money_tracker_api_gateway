package dev.boog.money_tracker_api_gateway.dataservice.controllers;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.request.RequestBudgetDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseBudgetDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseDto;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Read;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Write;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Profile(Constants.Profile.DOCS)
@Tag( name = Constants.Tags.DATA_SERVICE)
@Tag( name = Constants.Tags.BUDGET_API)
@RestController
@RequestMapping(Constants.Services.DATA_SERVICE_BASE_PATH + "/budgets")
public class BudgetController {

    @Operation(description = "create a new budget")
    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @RequestBody
                                         @Validated(Write.class)
                                         RequestBudgetDto dto) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "search one or more budgets based on input request")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto<ResponseBudgetDto>> get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                              @RequestBody(required = false)
                                                              @Validated(Read.class)
                                                              RequestBudgetDto req) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "update an existing budget")
    @PutMapping
    public ResponseEntity<ResponseBudgetDto> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                    @RequestBody
                                                    @Validated(Write.class)
                                                    RequestBudgetDto dto) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "delete an existing budget")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @PathVariable Long id) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }
}
