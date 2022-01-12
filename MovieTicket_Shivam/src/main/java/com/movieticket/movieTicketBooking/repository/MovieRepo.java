package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.AudiDtoCopy;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

}
