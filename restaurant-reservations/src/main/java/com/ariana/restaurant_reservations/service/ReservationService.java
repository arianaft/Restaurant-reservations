package com.ariana.restaurant_reservations.service;

import com.ariana.restaurant_reservations.exception.ReservationConflictException;
import com.ariana.restaurant_reservations.exception.ResourceNotFoundException;
import com.ariana.restaurant_reservations.model.Customer;
import com.ariana.restaurant_reservations.model.Reservation;
import com.ariana.restaurant_reservations.model.ReservationStatus;
import com.ariana.restaurant_reservations.model.RestaurantTable;
import com.ariana.restaurant_reservations.repository.CustomerRepository;
import com.ariana.restaurant_reservations.repository.ReservationRepository;
import com.ariana.restaurant_reservations.repository.RestauranTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestauranTableRepository restaurantTableRepository;

    @Autowired
    private CustomerRepository customerRepository;

    //Metodo todas las reservas
    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    //Metodo encuentra reservas por id
    public Optional<Reservation> getReservationById(Long id){
        return reservationRepository.findById(id);
    }


    //Metodo create Reservation, crea una reserva

    public Reservation createReservation(Reservation reservation){
        //Verifica mesa existente
        RestaurantTable table = restaurantTableRepository.findById(reservation.getTable().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Mesa no encontrada"));

        //Verifica cliente existente
        Customer customer = customerRepository.findById(reservation.getCustomer().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));


        //Verificar disponibilidad

        boolean isAvailable =
                reservationRepository.existsByTableAndReservationDateAndReservationTime(
                        table,
                        reservation.getReservationDate(),
                        reservation.getReservationTime()
                );
        if(isAvailable){
            throw new ReservationConflictException("La mesa ya está reservada para esa fecha y hora");

        }

        return  reservationRepository.save(reservation);

    }

    //Método cancelar

    public Reservation cancelReservation(Long id){
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()  -> new ResourceNotFoundException("Reserva no encontrada"));
        if(reservation.getStatus() == ReservationStatus.CANCELLED){
            return reservation;
        }
        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservationRepository.save(reservation);
    }


    //Método eliminar reserva
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }


}
