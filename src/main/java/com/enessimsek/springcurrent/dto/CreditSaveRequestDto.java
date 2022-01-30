package com.enessimsek.springcurrent.dto;

import com.enessimsek.springcurrent.entity.Customer;

import java.math.BigDecimal;
import java.util.Date;

public class CreditSaveRequestDto {

    private Long id;
    private String trId;
    private Customer customer;
    private BigDecimal creditLimit;
    private BigDecimal salaryAtCredit;
    private BigDecimal creditScore;
    private Boolean creditStatus;

    public String getTrId() {
        return trId;
    }

    @Override
    public String toString() {
        return "CreditSaveRequestDto{" +
                "id=" + id +
                ", trId='" + trId + '\'' +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", salaryAtCredit=" + salaryAtCredit +
                ", creditScore=" + creditScore +
                ", creditStatus=" + creditStatus +
                '}';
    }

    public void setTrId(String trId) {
        this.trId = trId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }


    public BigDecimal getSalaryAtCredit() {
        return salaryAtCredit;
    }

    public void setSalaryAtCredit(BigDecimal salaryAtCredit) {
        this.salaryAtCredit = salaryAtCredit;
    }

    public BigDecimal getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(BigDecimal creditScore) {
        this.creditScore = creditScore;
    }

    public Boolean getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
    }

}
