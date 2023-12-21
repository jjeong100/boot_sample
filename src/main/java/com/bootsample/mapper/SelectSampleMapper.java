package com.bootsample.mapper;

import java.util.List;

import com.bootsample.dto.SelectSampleDto;
import com.bootsample.dto.SatisfactionSurveyDto;
import com.bootsample.dto.SurveyAccountDto;
import com.bootsample.dto.SurveyContactDto;

public interface SelectSampleMapper {
    
    public List<SatisfactionSurveyDto> getSatisfactionSurveyList(SelectSampleDto dto)throws Exception;

    public List<SurveyContactDto> getContact(String personAccountId)throws Exception;

    public List<SurveyAccountDto> getAccount(String businessAccountId)throws Exception;

}
