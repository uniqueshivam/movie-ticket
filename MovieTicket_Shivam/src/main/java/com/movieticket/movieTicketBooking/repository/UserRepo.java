package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<user,Integer> {
}
