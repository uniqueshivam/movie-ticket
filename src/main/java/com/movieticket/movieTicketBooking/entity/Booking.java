package com.movieticket.movieTicketBooking.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int booking_id;

    @ManyToOne
    @JoinColumn(name = "audi_id",referencedColumnName = "id")
    private Audi audi;

    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "id")
    private Movie movie;

    @Column(name ="booking_time")
    private Date bookingTime;

    @Column(name = "total_amount")
    private double totalAmount;

//    @JoinTable(name = "seat-booked",joinColumns = @JoinColumn(name="seat_id",referencedColumnName = "seatid"),inverseJoinColumns = @JoinColumn(name="booking_id",referencedColumnName = "booking_id"))
//    @OneToMany
//    @JoinColumn(name = "seatid")
//    private List<Seat> listOfSeats;

}
