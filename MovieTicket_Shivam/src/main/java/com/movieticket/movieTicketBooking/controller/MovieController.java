package com.movieticket.movieTicketBooking.controller;


import com.movieticket.movieTicketBooking.converter.SearchWithMovieAndCityConverter;
import com.movieticket.movieTicketBooking.converter.SeatConverter;
import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.AudiDtoCopy;
import com.movieticket.movieTicketBooking.dto.SearchWithMovieAndCityDto;
import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Movie;
import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.service.AudiService;
import com.movieticket.movieTicketBooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieController {

    @Autowired
    public MovieService movieService;
    @Autowired
    public SearchWithMovieAndCityConverter searchWithMovieAndCityConverter;
    @Autowired
    public SeatConverter seatConverter;
    @Autowired
    public AudiService audiService;

    @GetMapping("/getAll")
    public List<Movie> getAllMovie()
    {
        return movieService.getallMovie();
    }

    @PostMapping("/saveMovie")
    public void saveMovie(@RequestBody Movie movie)
    {
        movieService.saveMovie(movie);
    }

    @GetMapping("/searchWithMovieAndCity/{movieName}/{cityName}")
    public List<SearchWithMovieAndCityDto> searchWithMovieAndCity(@PathVariable String movieName, @PathVariable  String cityName)
    {
        return searchWithMovieAndCityConverter.convertListOfAudiEntityToDto(audiService.findAudiByMovieAndCity(movieName,cityName));
    }

    @GetMapping("/searchMovieWithCity/{cityName}")
    public List<SearchWithMovieAndCityDto> searchWithCityOnly(@PathVariable String cityName)
    {
        return searchWithMovieAndCityConverter.convertListOfAudiEntityToDto((audiService.findAudiByCityOnly(cityName)));
    }

}
