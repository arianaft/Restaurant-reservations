package com.ariana.restaurant_reservations.repository;

import com.ariana.restaurant_reservations.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
