package com.loan.controller;

import com.loan.entity.Customer;
import com.loan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(
            @RequestBody Customer customer) {

        return ResponseEntity.ok(
                customerRepository.save(customer)
        );
    }
}