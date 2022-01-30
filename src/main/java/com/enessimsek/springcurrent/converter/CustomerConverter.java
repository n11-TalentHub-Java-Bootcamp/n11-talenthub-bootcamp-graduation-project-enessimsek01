package com.enessimsek.springcurrent.converter;
import com.enessimsek.springcurrent.dto.CustomerDto;
import com.enessimsek.springcurrent.dto.CustomerSaveRequestDto;
import com.enessimsek.springcurrent.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerConverter {

    CustomerConverter INSTANCE= Mappers.getMapper(CustomerConverter.class);

    CustomerDto convertCustomerToCustomerDto(Customer customer);

    Customer convertCustomerDtoToCustomer(CustomerDto customerDto);

    Customer convertCustomerDtoToCustomer(CustomerSaveRequestDto customerSaveRequestDto);

    List<CustomerDto> convertAllCustomerListToCustomerDtoList(List<Customer> customerList);

    Customer convertCustomerSaveRequestDtoToCustomer(CustomerSaveRequestDto customerSaveRequestDto);

}
