package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.repository.AudiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudiService {
    @Autowired
    public AudiRepo audiRepo;

    public List<Audi> getAllAudi()
    {
        return audiRepo.findAll();
    }

    public void addAudi(Audi newAudi)
    {

        audiRepo.save(newAudi);
    }

    public Audi getAudiById(int id)
    {
        return audiRepo.findById(id).get();
    }

    public int deleteAudiById(int id)
    {
        audiRepo.deleteById(id);
        return id;
    }

    public List<Audi> findAudiByMovieAndCity(String movieName, String city)
    {
        return audiRepo.findByMovieNameAndTheaterCity(movieName,city);
    }

    public List<Audi> findAudiByCityOnly(String city)
    {
        return audiRepo.findByTheaterCity(city);
    }

    public Audi getSeatListWithMovieAndTheaterId(int movieId, int audiId)
    {
        return audiRepo.findByMovieIdAndId(movieId, audiId);
    }
}
