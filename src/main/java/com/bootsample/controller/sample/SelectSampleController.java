package com.bootsample.controller.sample;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootsample.dto.SelectSampleDto;
import com.bootsample.payload.bootsample.SelectSamplePayload;
import com.bootsample.service.SelectSampleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Select Sample", description = "Select Sample. ")
@RestController
@RequiredArgsConstructor
public class SelectSampleController {
    @Autowired
    private final SelectSampleService service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "조회 견본", description = "조회 견본")
    @ApiResponse(content = @Content(schema = @Schema(implementation = SelectSamplePayload.Response.class)))
    @PostMapping(value = "/api/v1/SelectSample")
    public Object getObject(@Valid @RequestBody SelectSamplePayload.Request request) throws Exception {
        
        SelectSamplePayload.Response response = new SelectSamplePayload.Response();
        ModelMapper modelMapper = new ModelMapper();
        try {
            SelectSampleDto resultDto = new SelectSampleDto();
            SelectSampleDto dto = defaultMapper.map(request, SelectSampleDto.class);
           
            resultDto = service.getObject(dto);
            
            response = modelMapper.map(resultDto, SelectSamplePayload.Response.class);
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
        }

        return response;
    }
}
