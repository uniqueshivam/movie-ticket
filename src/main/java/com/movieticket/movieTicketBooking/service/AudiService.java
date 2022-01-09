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
}
