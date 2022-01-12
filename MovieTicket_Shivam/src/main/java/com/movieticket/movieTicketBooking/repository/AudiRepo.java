package com.movieticket.movieTicketBooking.repository;


import com.movieticket.movieTicketBooking.entity.Audi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AudiRepo extends JpaRepository<Audi,Integer> {


//    @Query("From Audi where movie.name = :movieName and theater.city = :city")
    public List<Audi> findByMovieNameAndTheaterCity (String movieName, String city);
    public List<Audi> findByTheaterCity(String city);
}
