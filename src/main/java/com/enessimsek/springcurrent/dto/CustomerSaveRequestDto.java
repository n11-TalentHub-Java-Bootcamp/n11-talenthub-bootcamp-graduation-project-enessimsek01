package com.enessimsek.springcurrent.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CustomerSaveRequestDto {

    private String trId;
    private String email;
    private String name;
    private String surname;
    private BigDecimal salary;
    private String phone;
    private Date birthDate;

    public String getTrId() {
        return trId;
    }

    public void setTrId(String trId) {
        this.trId = trId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CustomerSaveRequestDto{" +
                "trId='" + trId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
