package com.dp.micro.brewry.dpmsscbrewry.service;

import com.dp.micro.brewry.dpmsscbrewry.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    CustomerDto create(CustomerDto customerDto);

    CustomerDto update(UUID id,CustomerDto customerDto);

    void delete(UUID id);

}
