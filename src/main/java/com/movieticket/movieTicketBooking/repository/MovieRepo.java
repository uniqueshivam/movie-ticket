package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

    @Query(value = "select A.id as id,A.totalseats as totalSeats,A.name as name,M.name as movieName,T.name as theaterName , T.city as city from audi A inner join movie M on A.movieid = M.id inner join theater T on A.theaterid = T.id having M.name = ?1 and city = ?2",nativeQuery = true)
    public List<AudiDto> searchWithMovieAndCity(String movieName, String cityName);
//    public List<Audi> searchWithCityOnly(String cityName);
}
