package dev.boog.money_tracker_api_gateway.dataservice.controllers;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.request.RequestWalletDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseWalletDto;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Read;
import dev.boog.money_tracker_api_gateway.exceptions.validations.Write;
import dev.boog.money_tracker_api_gateway.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Profile(Constants.Profile.DOCS)
@Tag( name = "Wallet API")
@RestController
@RequestMapping("/data/wallets")
public class WalletController {

    @Operation(description = "create a new wallet")
    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @Parameter(
                                                 name = "request",
                                                 description = "the input request")
                                         @RequestBody
                                         RequestWalletDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "search one or more wallets based on input request")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto<ResponseWalletDto>> get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                              @Parameter(
                                                                      name = "request",
                                                                      description = "the input request")
                                                              @RequestBody(required = false)
                                                              @Validated(Read.class)
                                                              RequestWalletDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "search one or more wallets based on input request, get the details of children")
    @PostMapping("/search/details")
    public ResponseEntity<ResponseDto<ResponseWalletDto>> details(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                  @Parameter(
                                                                          name = "request",
                                                                          description = "the input request")
                                                                  @RequestBody
                                                                  @Validated(Read.class)
                                                                  RequestWalletDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "update an existing wallet")
    @PutMapping
    public ResponseEntity<ResponseWalletDto> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                    @Parameter(
                                                            name = "request",
                                                            description = "the input request")
                                                    @RequestBody
                                                    @Validated(Write.class)
                                                    RequestWalletDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "delete an existing wallet")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @Parameter(
                                                 name = "id",
                                                 description = "the id of object to be deleted")
                                         @PathVariable Long id) {
        throw new NotImplementedException();
    }

}
