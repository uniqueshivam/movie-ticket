package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
