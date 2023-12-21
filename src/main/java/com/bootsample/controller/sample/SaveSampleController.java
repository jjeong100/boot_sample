package com.bootsample.controller.sample;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootsample.dto.SaveSampleDto;
import com.bootsample.payload.bootsample.SaveSamplePayload;
import com.bootsample.service.SaveSampleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Save Sample", description = "Save Sample")
@RestController
@RequiredArgsConstructor
public class SaveSampleController {
    @Autowired
    private final SaveSampleService service;

    private final ModelMapper defaultMapper;

    @Operation(summary = "저장 견본", description = "저장 견본")
    @ApiResponse(content = @Content(schema = @Schema(implementation = SaveSamplePayload.Response.class)))
    @PostMapping(value = "/api/v1/SaveSample")
    public Object upsertObject(@Valid @RequestBody SaveSamplePayload.Request request) throws Exception {
        UUID IF_TR_ID = UUID.randomUUID();
        
        SaveSamplePayload.Response response = new SaveSamplePayload.Response();
        
        try {
            ModelMapper modelMapper = new ModelMapper();
            SaveSampleDto dto = defaultMapper.map(request, SaveSampleDto.class);
            
            SaveSampleDto resultDto = service.upsertObject(dto);
    
            response = modelMapper.map(resultDto, SaveSamplePayload.Response.class);
        }catch(Exception e) {
            response.setErrorSpcCode("500");
            response.setErrorSpcMessage(e.getLocalizedMessage());
        }
        return response;
    }

}
