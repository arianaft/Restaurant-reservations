package com.ariana.restaurant_reservations.controler;

import com.ariana.restaurant_reservations.model.Reservation;
import com.ariana.restaurant_reservations.repository.ReservationRepository;
import com.ariana.restaurant_reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")

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

    //Método PUT

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Reservation> cancelReservation(@PathVariable Long id){
       return  ResponseEntity.ok(reservationService.cancelReservation(id));
    }



}
