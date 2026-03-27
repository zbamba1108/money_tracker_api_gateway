package dev.boog.money_tracker_api_gateway.dataservice.controllers;

import dev.boog.money_tracker_api_gateway.dataservice.dtos.request.RequestCategoryDto;
import dev.boog.money_tracker_api_gateway.dataservice.dtos.response.ResponseCategoryDto;
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
@Tag( name = "Data API")
@Tag(name = "Category API")
@RestController
@RequestMapping("/data/categories")
public class CategoryController {

    @Operation(description = "create a new category")
    @PostMapping
    public ResponseEntity<String> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @RequestBody
                                         @Validated(Write.class)
                                         RequestCategoryDto dto) {
        throw new NotImplementedException();
    }

    @Operation(description = "search one or more categories based on input request")
    @PostMapping("/search")
    public ResponseEntity<ResponseDto<ResponseCategoryDto>> get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                @RequestBody(required = false)
                                                                @Validated(Read.class)
                                                                RequestCategoryDto req) {
        throw new NotImplementedException();
    }

    @Operation(description = "update an existing category")
    @PutMapping
    public ResponseEntity<ResponseCategoryDto> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                      @RequestBody
                                                      @Validated(Write.class)
                                                      RequestCategoryDto dto) {
        throw new NotImplementedException();
    }

    @Operation(description = "delete an existing category")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                         @PathVariable Long id) {
        throw new NotImplementedException();
    }
}
