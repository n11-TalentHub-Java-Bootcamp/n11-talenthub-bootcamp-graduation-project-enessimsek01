package com.enessimsek.springcurrent.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class CreditScoreService {


    public BigDecimal findCreditScore(String trId){
        int rndCreditScore = ThreadLocalRandom.current().nextInt(0, 1901);
        return BigDecimal.valueOf(rndCreditScore);
    }
}
