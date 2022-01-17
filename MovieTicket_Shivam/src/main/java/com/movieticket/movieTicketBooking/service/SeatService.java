package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.repository.SeatRepo;
import jdk.jfr.StackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public List<Seat> getSeatListWithMovieAndTheaterId(int movieId, int audiId,int notBooked)
    {
        return seatRepo.findByAudiIdAndAudiMovieIdAndIsBookedAndIsReserved(audiId,movieId,notBooked,0);
    }


    @Transactional
    public List<Seat> getListOfSeatsToBeBooked(List<Integer> seatIds)
    {

        return seatRepo.getListOfSeatsToBeBooked(seatIds);
    }

    @Transactional
    public void reserveToggleSeat(List<Integer> seatIds, int reserveToggle){
        seatRepo.reserveToggleSeat(seatIds,reserveToggle);
    }

    @Transactional
    public void removeReservedByUserAfterBooking(List<Seat> seatsBooked)
    {
        for(Seat seat:seatsBooked)
        {
            seat.setReservedByUser(null);
            seatRepo.save(seat);
        }
    }


}
