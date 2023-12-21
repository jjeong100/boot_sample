package com.bootsample.service;

import com.bootsample.dto.SaveSampleDto;

public interface SaveSampleService {
    
    public SaveSampleDto upsertObject(SaveSampleDto dto)throws Exception;
}
