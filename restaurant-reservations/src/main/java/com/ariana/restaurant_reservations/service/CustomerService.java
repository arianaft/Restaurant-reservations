package com.ariana.restaurant_reservations.service;

import com.ariana.restaurant_reservations.model.Customer;
import com.ariana.restaurant_reservations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //Método que devuelva clientes
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    };

    //Método buscar cliente por id

}
