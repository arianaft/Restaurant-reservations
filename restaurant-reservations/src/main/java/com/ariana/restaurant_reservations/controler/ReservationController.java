package com.ariana.restaurant_reservations.controler;

import com.ariana.restaurant_reservations.model.Reservation;
import com.ariana.restaurant_reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")

public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    //Endpoint GET devuelve las reservas
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    //Endpoint GET devuelve reserva por id

    @GetMapping
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id){
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



}
