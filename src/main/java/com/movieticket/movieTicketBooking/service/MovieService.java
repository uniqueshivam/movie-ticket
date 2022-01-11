package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.entity.Movie;
import com.movieticket.movieTicketBooking.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepo movieRepo;

    public List<Movie> getallMovie()
    {
        return movieRepo.findAll();
    }

    public void saveMovie(Movie newMovie)
    {
        movieRepo.save(newMovie);
    }

    public List<AudiDto> searchWithMovieAndCity(String movieName, String cityName)
    {
        System.out.println(movieRepo.searchWithMovieAndCity(movieName,cityName));
        return movieRepo.searchWithMovieAndCity(movieName,cityName);
    }

}
