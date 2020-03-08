package com.dp.micro.brewry.dpmsscbrewry.service;

import com.dp.micro.brewry.dpmsscbrewry.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        log.info("Get Customer for : {}", id);
        return CustomerDto.builder().id(id).name("test").build();
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        log.info("Saving new customer with name : {}", customerDto.getName());
        return CustomerDto.builder().id(UUID.randomUUID()).name(customerDto.getName()).build();
    }

    @Override
    public CustomerDto update(UUID id, CustomerDto customerDto) {
        log.info("updating customer with id : {}", id);
        return customerDto;
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting customer for : {}", id);
    }
}
