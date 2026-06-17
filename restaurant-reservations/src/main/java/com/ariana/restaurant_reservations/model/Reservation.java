package com.ariana.restaurant_reservations.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate reservationDate;

    @Column(nullable=false)
    private LocalTime reservationTime;

    @Column(nullable=false)
    private  Integer numberOfGuests;

    @Enumerated(EnumType.STRING)
    private  ReservationStatus status;

    @ManyToOne
    @JoinColumn(name= "customer_id", nullable=false)
    private Customer customer ;

    @ManyToOne
    @JoinColumn(name= "table_id", nullable=false)
    private RestaurantTable table ;

}
