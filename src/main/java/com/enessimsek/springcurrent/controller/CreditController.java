package com.enessimsek.springcurrent.controller;


import com.enessimsek.springcurrent.converter.CreditConverter;
import com.enessimsek.springcurrent.dto.CreditDto;
import com.enessimsek.springcurrent.entity.Credit;
import com.enessimsek.springcurrent.service.entityservice.CreditEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/credit")
public class CreditController {

    @Autowired
    private CreditEntityService creditEntityService;


    @GetMapping("/{trId}")
    public CreditDto findByTrId(String trId){
        CreditDto creditDto=creditEntityService.findByTrId(trId);
        return creditDto;
    }
    @PostMapping("")
    public CreditDto save(@RequestBody CreditDto creditDto){

        Credit credit = CreditConverter.INSTANCE.convertCreditDtoToCredit(creditDto);
        creditDto=creditEntityService.save(credit);

        return creditDto;
    }
}
