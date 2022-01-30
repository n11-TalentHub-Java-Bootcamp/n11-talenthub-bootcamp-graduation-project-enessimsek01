package com.enessimsek.springcurrent.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "credit")
public class Credit implements Serializable {

    @Id
    @SequenceGenerator(name = "generator",sequenceName = "credit_id_seq")
    @GeneratedValue(generator = "generator")
    @Column(name = "id")
    private Long id;
    @Column(name = "turkish_republic_id")
    private String trId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_credit_id")
    private Customer customer;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "salary_credit")
    private BigDecimal salaryAtCredit;

    @Column(name = "credit_score")
    private BigDecimal creditScore;

    @Column(name = "credit_status")
    private Boolean creditStatus;

    @Column(name = "assurance")
    private BigDecimal assurance;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public BigDecimal getAssurance() {
        return assurance;
    }

    public void setAssurance(BigDecimal assurance) {
        this.assurance = assurance;
    }

    public String getTrId() {
        return trId;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", trId='" + trId + '\'' +
                ", customer=" + customer +
                ", creditLimit=" + creditLimit +
                ", createdDate=" + createdDate +
                ", salaryAtCredit=" + salaryAtCredit +
                ", creditScore=" + creditScore +
                ", creditStatus=" + creditStatus +
                ", assurance=" + assurance +
                '}';
    }

    public void setTrId(String trId) {
        this.trId = trId;
    }

}
