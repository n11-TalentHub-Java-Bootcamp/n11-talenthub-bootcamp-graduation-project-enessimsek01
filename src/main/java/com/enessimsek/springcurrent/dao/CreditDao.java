package com.enessimsek.springcurrent.dao;

import com.enessimsek.springcurrent.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditDao extends JpaRepository<Credit,Long> {

     Credit findByTrId(String trId);

}
