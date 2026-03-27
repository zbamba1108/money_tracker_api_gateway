package dev.boog.money_tracker_api_gateway.dataservice.controllers;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.request.*;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.*;
import dev.boog.money_tracker_api_gateway.exceptions.validations.*;
import dev.boog.money_tracker_api_gateway.utils.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import org.apache.commons.lang3.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;


@Profile(Constants.Profile.DOCS)
@Tag( name = Constants.Tags.DATA_SERVICE)
@Tag( name = Constants.Tags.TRANSACTION_API)
@RestController
@RequestMapping("/data/transactions")
public class TransactionController {

    @Operation(description = "create a new transaction")
    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @RequestBody
                                         @Validated(Write.class)
                                         RequestTransactionDto transaction) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "search one or more transactions based on input request")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto<ResponseTransactionDto>> get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                   @RequestBody(required = false)
                                                                   @Validated(Read.class)
                                                                   RequestTransactionDto req) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "search one or more wallets based on input request, get the details of children")
    @PostMapping("/search/details")
    public ResponseEntity<ResponseDto<ResponseTransactionDto>> details(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                       @RequestBody(required = false)
                                                                       @Validated(Read.class)
                                                                       RequestTransactionDto req) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "update an existing transaction")
    @PutMapping
    public ResponseEntity<ResponseTransactionDto> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                         @RequestBody
                                                         @Validated(Write.class)
                                                         RequestTransactionDto dto) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

    @Operation(description = "delete an existing transaction")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @PathVariable Long id) {
        throw new NotImplementedException(Constants.Messages.DOCS_METHOD);
    }

}
