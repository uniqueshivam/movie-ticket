package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepo extends JpaRepository<Theater,Integer> {
}
