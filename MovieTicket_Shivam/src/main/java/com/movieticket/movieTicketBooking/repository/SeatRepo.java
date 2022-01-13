package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    public List<Seat> findByAudiIdAndAudiMovieIdAndIsBooked(int audiId,int movieId,int notBooked);
}
