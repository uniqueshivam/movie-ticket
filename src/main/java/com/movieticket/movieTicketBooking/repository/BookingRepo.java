package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
