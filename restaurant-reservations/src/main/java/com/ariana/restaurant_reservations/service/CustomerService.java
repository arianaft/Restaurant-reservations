package com.ariana.restaurant_reservations.service;

import com.ariana.restaurant_reservations.model.Customer;
import com.ariana.restaurant_reservations.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //Método que devuelva clientes
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //Método buscar cliente por id
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    //Método guardar cliente
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //Método eliminar cliente
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
