package com.enessimsek.springcurrent.dto;

import com.enessimsek.springcurrent.entity.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class CreditDto {

    private Long id;
    private String trId;
    private Customer customer;
    private BigDecimal creditLimit;
    private BigDecimal salaryAtCredit;
    private BigDecimal creditScore;
    private Boolean creditStatus;

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getTrId() {
        return trId;
    }

    @Override
    public String toString() {
        return "CreditDto{" +
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

    public BigDecimal getSalaryAtCredit() {
        return salaryAtCredit;
    }

    public void setSalaryAtCredit(BigDecimal salaryAtCredit) {
        this.salaryAtCredit = salaryAtCredit;
    }

    public Boolean getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
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

    public BigDecimal getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(BigDecimal creditScore) {
        this.creditScore = creditScore;
    }

}
