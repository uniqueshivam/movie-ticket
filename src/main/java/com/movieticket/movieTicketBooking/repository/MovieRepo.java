package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
}
