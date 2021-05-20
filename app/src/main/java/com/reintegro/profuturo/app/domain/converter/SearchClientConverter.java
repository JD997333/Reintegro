package com.reintegro.profuturo.app.domain.converter;

import com.reintegro.profuturo.app.data.entity.SearchClientEntity;
import com.reintegro.profuturo.app.domain.dto.SearchClientDto;

public class SearchClientConverter {
    public static SearchClientEntity convertFromDto(SearchClientDto searchClientDto) {
        SearchClientEntity searchClientEntity;
        searchClientEntity = new SearchClientEntity();
        searchClientEntity.setAccountNumber(searchClientDto.getAccountNumber());
        searchClientEntity.setCurp(searchClientDto.getCurp());
        searchClientEntity.setNss(searchClientDto.getNss());

        return searchClientEntity;
    }
}
