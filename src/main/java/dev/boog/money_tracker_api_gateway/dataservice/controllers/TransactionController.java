package dev.boog.money_tracker_api_gateway.dataservice.controllers;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.request.RequestTransactionDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseTransactionDto;
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
@Tag( name = "Data API")
@Tag(name = "Transaction API")
@RestController
@RequestMapping("/data/transactions")
public class TransactionController {

    @Operation(description = "create a new transaction")
    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @RequestBody
                                         @Validated(Write.class)
                                         RequestTransactionDto transaction) {
        throw new NotImplementedException();
    }

    @Operation(description = "search one or more transactions based on input request")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto<ResponseTransactionDto>> get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                   @RequestBody(required = false)
                                                                   @Validated(Read.class)
                                                                   RequestTransactionDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "search one or more wallets based on input request, get the details of children")
    @PostMapping("/search/details")
    public ResponseEntity<ResponseDto<ResponseTransactionDto>> details(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                       @RequestBody(required = false)
                                                                       @Validated(Read.class)
                                                                       RequestTransactionDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "update an existing transaction")
    @PutMapping
    public ResponseEntity<ResponseTransactionDto> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                         @RequestBody
                                                         @Validated(Write.class)
                                                         RequestTransactionDto dto) {
        throw new NotImplementedException();
    }

    @Operation(description = "delete an existing transaction")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @PathVariable Long id) {
        throw new NotImplementedException();
    }

}
