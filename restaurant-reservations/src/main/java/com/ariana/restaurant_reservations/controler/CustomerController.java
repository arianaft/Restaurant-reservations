package com.ariana.restaurant_reservations.controler;

import com.ariana.restaurant_reservations.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;




}
