package com.enessimsek.springcurrent.controller;


import com.enessimsek.springcurrent.converter.CustomerConverter;
import com.enessimsek.springcurrent.dto.CreditResultDto;
import com.enessimsek.springcurrent.dto.CustomerDto;
import com.enessimsek.springcurrent.dto.CustomerSaveRequestDto;
import com.enessimsek.springcurrent.entity.Customer;
import com.enessimsek.springcurrent.service.entityservice.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerEntityService customerEntityService;


    @GetMapping("/{trId}")
    public CustomerDto findByTrId(@PathVariable String trId){

        CustomerDto customerDto=customerEntityService.findByTrId(trId);

        return customerDto;
    }

    @PostMapping("")
    public CreditResultDto save(@RequestBody CustomerSaveRequestDto customerSaveRequestDto){

        Customer customer=CustomerConverter.INSTANCE.convertCustomerDtoToCustomer(customerSaveRequestDto);

        CreditResultDto creditResultDto = customerEntityService.save(customer);

        return creditResultDto;
    }

    @DeleteMapping("/{trId}")
    public void deleteByTrId(@PathVariable String trId){

        customerEntityService.deleteByTrId(trId);

    }

}
