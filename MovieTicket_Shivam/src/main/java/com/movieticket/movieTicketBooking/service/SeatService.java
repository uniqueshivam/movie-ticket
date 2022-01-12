package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    public SeatRepo seatRepo;

    public List<Seat> getAllSeat()
    {
        return seatRepo.findAll();

    }

    public void saveSeat(Seat newSeat)
    {
        seatRepo.save(newSeat);
    }


}
