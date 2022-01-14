package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
