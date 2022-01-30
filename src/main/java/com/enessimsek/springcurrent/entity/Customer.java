package com.enessimsek.springcurrent.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "customer_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$")
    @Column(name = "turkish_republic_id", unique = true, nullable = false,updatable = false)//column name küçült
    @Size(min=11,max = 11)
    private String trId;

    @Email
    private String email;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "birth_date", nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "customer_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "assurance")
    private BigDecimal assurance;

    public BigDecimal getAssurance() {
        return assurance;
    }

    public void setAssurance(BigDecimal assurance) {
        this.assurance = assurance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrId() {
        return trId;
    }

    public void setTrId(String trId) {
        this.trId = trId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", trId='" + trId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", createdDate=" + createdDate +
                ", assurance=" + assurance +
                '}';
    }
}
