package com.enessimsek.springcurrent.service.entityservice;

import com.enessimsek.springcurrent.converter.CustomerConverter;
import com.enessimsek.springcurrent.dao.CustomerDao;
import com.enessimsek.springcurrent.dto.CreditResultDto;
import com.enessimsek.springcurrent.dto.CustomerDto;
import com.enessimsek.springcurrent.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerEntityService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CreditEntityService creditEntityService;



    public List<CustomerDto> findAll(){

        List<Customer> customerList=customerDao.findAll();

        List<CustomerDto> customerDtoList= CustomerConverter.INSTANCE.convertAllCustomerListToCustomerDtoList(customerList);

        return customerDtoList;
    }

    public CustomerDto findByTrId(String trId){

        Customer customer = customerDao.findByTrId(trId);

        CustomerDto customerDto = CustomerConverter.INSTANCE.convertCustomerToCustomerDto(customer);

        return customerDto;

    }

    public CreditResultDto save(Customer customer){

        Customer saveCustomer = customerDao.save(customer);

        CreditResultDto creditResultDto = creditEntityService.apply(saveCustomer);

        return creditResultDto;
    }

    public void delete(Customer customer){
       customerDao.delete(customer);

    }

    public void deleteByTrId(String trId){
        customerDao.deleteByTrId(trId);
    }

}
