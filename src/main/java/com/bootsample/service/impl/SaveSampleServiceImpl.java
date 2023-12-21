package com.bootsample.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootsample.dto.SaveSampleDto;
import com.bootsample.mapper.SaveSampleMapper;
import com.bootsample.service.SaveSampleService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveSampleServiceImpl implements SaveSampleService{
    
    private final SaveSampleMapper mapper;  

    public SaveSampleDto upsertObject(SaveSampleDto dto)throws Exception{

        SaveSampleDto resultDto = new SaveSampleDto();
        int parRowCheckNum = mapper.getParRowCheck(dto);
        
        mapper.insertObject(dto);
        
        if(parRowCheckNum > 0){
            HashMap<String, String> map = new HashMap<>();

            map.put("PARAM_ID", dto.getRowId());
            map.put("checkcu", "update");  
            map.put("ACCOUNT_ID", dto.getContactId());   
          
            mapper.transferProcess(map);

            mapper.transferReplica(map);
            
            String loyaltyStatus = mapper.getObject(dto);

            resultDto.setContactId(dto.getContactId());
            resultDto.setLoyaltyStatus(loyaltyStatus);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
            
        }else{
            HashMap<String, String> map = new HashMap<>();

            
            map.put("PARAM_ID", dto.getRowId());
            map.put("ACCOUNT_ID", dto.getContactId());   
            map.put("checkcu", "insert");  
            mapper.transferProcess(map);
            mapper.transferReplica(map);

            String loyaltyStatus = mapper.getObject(dto);

            resultDto.setContactId(dto.getContactId());
            resultDto.setLoyaltyStatus(loyaltyStatus);
            resultDto.setErrorSpcCode("0");
            resultDto.setErrorSpcMessage("OK");
        }

        return resultDto;
    }
}
