package com.bootsample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootsample.dto.SelectSampleDto;
import com.bootsample.dto.SatisfactionSurveyDto;
import com.bootsample.dto.SurveyAccountDto;
import com.bootsample.dto.SurveyContactDto;
import com.bootsample.mapper.SelectSampleMapper;
import com.bootsample.service.SelectSampleService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SelectSampleServiceImpl implements SelectSampleService{
    
    private final SelectSampleMapper mapper;

    public SelectSampleDto getObject(SelectSampleDto dto)throws Exception{
        SelectSampleDto resulDto = new SelectSampleDto();

        List<SatisfactionSurveyDto> satisfactionSurveyList = new ArrayList<>();

        satisfactionSurveyList = mapper.getSatisfactionSurveyList(dto);

        if(0 < satisfactionSurveyList.size()){
            
            for(int i=0; i < satisfactionSurveyList.size(); i++){
                if(satisfactionSurveyList.get(i).getPersonAccountId() != null){
                    String personAccountId = satisfactionSurveyList.get(i).getPersonAccountId();
                    List<SurveyContactDto> listOfContact = new ArrayList<>();
                    listOfContact = mapper.getContact(personAccountId);
                    satisfactionSurveyList.get(i).setListOfContact(listOfContact);
                }
                if(satisfactionSurveyList.get(i).getBusinessAccountId() != null){
                    List<SurveyAccountDto> listOfAccount = new ArrayList<>();
                    String businessAccountId = satisfactionSurveyList.get(i).getBusinessAccountId();
                    listOfAccount = mapper.getAccount(businessAccountId);
                    satisfactionSurveyList.get(i).setListOfAccount(listOfAccount);
                }
            }
            resulDto.setErrorSpcCode("0");
            resulDto.setErrorSpcMessage("OK");
            resulDto.setListOfSatisfactionSurvey(satisfactionSurveyList);  
        }else{
            resulDto.setErrorSpcCode("1");
            resulDto.setErrorSpcMessage("No Data");
        }
        

        return resulDto;
    }
}
