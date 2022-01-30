package com.enessimsek.springcurrent.dto;

import java.math.BigDecimal;

public class CreditResultDto {

    private Boolean creditStatus;
    private BigDecimal creditLimit;

    public CreditResultDto() {
    }

    public CreditResultDto(Boolean creditStatus, BigDecimal creditLimit) {
        this.creditStatus = creditStatus;
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "CreditResultDto{" +
                "creditStatus=" + creditStatus +
                ", creditLimit=" + creditLimit +
                '}';
    }

    public Boolean getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
