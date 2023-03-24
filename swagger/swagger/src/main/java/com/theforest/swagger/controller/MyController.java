package com.theforest.swagger.controller;

import com.theforest.swagger.controller.dto.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SecurityRequirement(name = "")
@RestController
public class MyController {

    @Operation(summary = "Get message \"hello\"")
    @ApiResponse(responseCode = "200", description = "get message hello")
    @PostMapping("/hello")
    public MessageDto hello(@RequestBody @Valid MessageDto dto) {
        return dto;
    }
}
