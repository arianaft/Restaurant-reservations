package com.ariana.restaurant_reservations.service;

import com.ariana.restaurant_reservations.repository.CustomerRepository;
import com.ariana.restaurant_reservations.repository.ReservationRepository;
import com.ariana.restaurant_reservations.repository.RestauranTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestauranTableRepository restaurantTableRepository;

    @Autowired
    private CustomerRepository customerRepository;
}
