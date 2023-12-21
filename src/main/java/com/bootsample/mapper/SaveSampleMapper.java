package com.bootsample.mapper;

import java.util.HashMap;

import com.bootsample.dto.SaveSampleDto;

public interface SaveSampleMapper {

    public int getParRowCheck(SaveSampleDto dto)throws Exception;

    public int insertObject(SaveSampleDto dto)throws Exception;

    public void transferProcess(HashMap<String, String> parMap)throws Exception;

    public void transferReplica(HashMap<String, String> parMap)throws Exception;

    public String getObject(SaveSampleDto dto)throws Exception;
    
}
