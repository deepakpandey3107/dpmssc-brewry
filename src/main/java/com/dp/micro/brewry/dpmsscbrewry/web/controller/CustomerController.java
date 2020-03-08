package com.dp.micro.brewry.dpmsscbrewry.web.controller;

import com.dp.micro.brewry.dpmsscbrewry.service.CustomerService;
import com.dp.micro.brewry.dpmsscbrewry.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto newCustomerDto = customerService.create(customerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{customerId}").build(newCustomerDto.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto){
        CustomerDto updateCustomerDto = customerService.update(customerId, customerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteCustomer(@PathVariable UUID customerId){
        customerService.delete(customerId);
    }
}
