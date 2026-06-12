package com.ariana.restaurant_reservations.repository;

import com.ariana.restaurant_reservations.model.RestaurantTable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranTableRepository extends JpaRepository <RestaurantTable, Long >{
}
