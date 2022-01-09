package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Theater;
import com.movieticket.movieTicketBooking.repository.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    public TheaterRepo theaterRepo;

    public List<Theater> getallTheater()
    {
        return theaterRepo.findAll();
    }

    public void saveTheater(Theater newTheater)
    {
        theaterRepo.save(newTheater);
    }
}
