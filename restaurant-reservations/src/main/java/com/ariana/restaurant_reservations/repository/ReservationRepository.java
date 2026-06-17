package com.ariana.restaurant_reservations.repository;

import com.ariana.restaurant_reservations.model.Reservation;
import com.ariana.restaurant_reservations.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservationRepository extends JpaRepository<Reservation ,Long > {
    //Metodo comprobar reserve de una mesa
    boolean existsByRestaurantTableAndReservationDateAndReservationTime(
            RestaurantTable table,
            LocalDate date,
            LocalTime time

    );
}
