package com.enessimsek.springcurrent.service.entityservice;


import com.enessimsek.springcurrent.converter.CreditConverter;
import com.enessimsek.springcurrent.dao.CreditDao;
import com.enessimsek.springcurrent.dto.CreditDto;
import com.enessimsek.springcurrent.dto.CreditResultDto;
import com.enessimsek.springcurrent.entity.Credit;
import com.enessimsek.springcurrent.entity.Customer;
import com.enessimsek.springcurrent.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditEntityService {

    @Autowired
    private CreditDao creditDao;

    @Autowired
    private CreditScoreService creditScoreService;

     BigDecimal creditConstant=BigDecimal.valueOf(4);


    public CreditDto save(Credit credit) {
        Credit saveCredit = creditDao.save(credit);
        CreditDto creditDto = CreditConverter.INSTANCE.convertCreditToCreditDto(credit);

        return creditDto;
    }


    public CreditDto findByTrId(String trId){

        Credit credit=creditDao.findByTrId(trId);

        CreditDto creditDto=CreditConverter.INSTANCE.convertCreditToCreditDto(credit);

        return creditDto;
    }

    public CreditResultDto apply(Customer customer) {
        BigDecimal creditScore = creditScoreService.findCreditScore(customer.getTrId());

        CreditResultDto creditResultDto = new CreditResultDto();


        if (creditScore.compareTo(BigDecimal.valueOf(500)) < 0) {
            creditResultDto.setCreditLimit(BigDecimal.valueOf(0));
            creditResultDto.setCreditStatus(Boolean.FALSE);
        } else if ((creditScore.compareTo(BigDecimal.valueOf(500)) >= 0 && creditScore.compareTo(BigDecimal.valueOf(1000)) < 0) && (customer.getSalary().compareTo(BigDecimal.valueOf(5000)) < 0)) {
            creditResultDto.setCreditStatus(Boolean.TRUE);
            if (customer.getAssurance() != null) {

                creditResultDto.setCreditLimit(BigDecimal.valueOf(10000).add(customer.getAssurance().multiply(BigDecimal.valueOf(0.1))));
            } else {
                creditResultDto.setCreditLimit(BigDecimal.valueOf(10000));

            }


        } else if ((creditScore.compareTo(BigDecimal.valueOf(500)) >= 0 && creditScore.compareTo(BigDecimal.valueOf(1000)) < 0) && (customer.getSalary().compareTo(BigDecimal.valueOf(5000)) >= 0) && customer.getSalary().compareTo(BigDecimal.valueOf(10000)) < 0) {
            creditResultDto.setCreditStatus(Boolean.TRUE);
            if (customer.getAssurance() != null) {

                creditResultDto.setCreditLimit(BigDecimal.valueOf(20000).add(customer.getAssurance().multiply(BigDecimal.valueOf(0.2))));
            } else {
                creditResultDto.setCreditLimit(BigDecimal.valueOf(20000));

            }
        } else if ((creditScore.compareTo(BigDecimal.valueOf(500)) >= 0 && creditScore.compareTo(BigDecimal.valueOf(1000)) < 0) && (customer.getSalary().compareTo(BigDecimal.valueOf(10000)) >= 0)) {
            creditResultDto.setCreditStatus(Boolean.TRUE);
            if (customer.getAssurance() != null) {

                creditResultDto.setCreditLimit((customer.getSalary().multiply(creditConstant).divide(BigDecimal.valueOf(2))).add(customer.getAssurance().multiply(BigDecimal.valueOf(0.25))));
            } else {
                creditResultDto.setCreditLimit(customer.getSalary().multiply(creditConstant).divide(BigDecimal.valueOf(2)));

            }

        }else if ((creditScore.compareTo(BigDecimal.valueOf(1000)) >= 0)) {
            creditResultDto.setCreditStatus(Boolean.TRUE);
            if (customer.getAssurance() != null) {

                creditResultDto.setCreditLimit((customer.getSalary().multiply(creditConstant)).add(customer.getAssurance().multiply(BigDecimal.valueOf(0.5))));
            } else {
                creditResultDto.setCreditLimit(customer.getSalary().multiply(creditConstant));

            }

        }
        Credit credit = new Credit();
        credit.setCustomer(customer);
        credit.setTrId(customer.getTrId());
        credit.setSalaryAtCredit(customer.getSalary());
        credit.setCreditLimit(creditResultDto.getCreditLimit());
        credit.setCreditStatus(creditResultDto.getCreditStatus());
        credit.setCreditScore(creditScore);
        credit.setAssurance(customer.getAssurance());
        creditDao.save(credit);
        return creditResultDto;
    }

    public void delete(Credit credit) {
        creditDao.delete(credit);
    }
}

