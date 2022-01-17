package com.movieticket.movieTicketBooking.converter;


import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.model.BookingMovie;
import com.movieticket.movieTicketBooking.service.SeatService;
import com.zaxxer.hikari.SQLExceptionOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserveSeat")
public class ReserveSeat {

    @Autowired public SeatService seatService;

    @PostMapping("/reserve")
    public boolean reserveSeat(@RequestBody BookingMovie bookingMovieJson)
    {

        try{
            List<Seat> seatsToBeBooked = seatService.forLockingTheSeats(bookingMovieJson.getLisOfSeatIdToBeBooked());
            for(Seat seat : seatsToBeBooked)
            {
                seat.setIsReserved(1);
                seat.setReservedByUserId(bookingMovieJson.getUserId());
                seatService.saveSeat(seat);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }


//        List<Seat> seatsToBeBooked = seatService.forLockingTheSeats(bookingMovieJson.getLisOfSeatIdToBeBooked());
//        //Testing locking using thread
//            Runnable t = new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        Thread.sleep(5000);
//                    }
//                    catch(Exception e)
//                    {
//
//                    }
//                    try{
//                        for(Seat currentSeat:seatsToBeBooked)
//                        {
//                            Seat tempSeat = currentSeat;
//                            tempSeat.setReserved(1);
//                            seatService.saveSeat(tempSeat);
//                        }
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.println(e.getMessage());
//                    }
//
//                }
//            };
//
//            Runnable t2 = new Runnable() {
//                @Override
//                public void run() {
//
//                    for(Seat currentSeat:seatsToBeBooked)
//                    {
//                        Seat tempSeat = currentSeat;
//                        tempSeat.setReserved(1);
//                        seatService.saveSeat(tempSeat);
//                    }
//
//                }
//            };
//
//            new Thread(t).start();
//            new Thread(t2).start();


        return true;

    }
}
