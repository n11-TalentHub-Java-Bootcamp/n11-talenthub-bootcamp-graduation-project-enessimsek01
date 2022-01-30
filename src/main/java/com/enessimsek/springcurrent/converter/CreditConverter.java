package com.enessimsek.springcurrent.converter;

import com.enessimsek.springcurrent.dto.CreditDto;
import com.enessimsek.springcurrent.dto.CreditSaveRequestDto;
import com.enessimsek.springcurrent.entity.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditConverter {

    CreditConverter INSTANCE = Mappers.getMapper(CreditConverter.class);

        CreditDto convertCreditToCreditDto(Credit credit);

        Credit convertCreditDtoToCredit(CreditDto creditDto);

    Credit convertCreditDtoToCredit(CreditSaveRequestDto creditSaveRequestDto);
        List<CreditDto> convertAllCreditListToCreditDtoList(List<Credit> creditList);

}
