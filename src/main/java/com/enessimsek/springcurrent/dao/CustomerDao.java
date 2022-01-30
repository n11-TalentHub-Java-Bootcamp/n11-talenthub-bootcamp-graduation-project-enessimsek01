package com.enessimsek.springcurrent.dao;

import com.enessimsek.springcurrent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {

    Customer findByTrId(String trId);
    Customer deleteByTrId(String trId);
}
