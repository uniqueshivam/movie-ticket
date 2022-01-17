package com.movieticket.movieTicketBooking.controller;


import com.movieticket.movieTicketBooking.converter.UserConverter;
import com.movieticket.movieTicketBooking.dto.UserDto;
import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.model.BookingMovie;
import com.movieticket.movieTicketBooking.service.SeatService;
import com.zaxxer.hikari.SQLExceptionOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/reserveSeat")
public class ReserveSeat {

    @Autowired public SeatService seatService;
    @Autowired public UserConverter userConverter;

    @PostMapping("/reserve")
    public boolean reserveSeat(@RequestBody BookingMovie bookingMovieJson)
    {

        try{
            List<Seat> seatsToBeBooked = seatService.getListOfSeatsToBeBooked(bookingMovieJson.getLisOfSeatIdToBeBooked());
            for(Seat seat : seatsToBeBooked)
            {
                seat.setIsReserved(1);
                seat.setReservedByUser(userConverter.userDtoToEntity(bookingMovieJson.getBookedOrReservedByUser()));
                seatService.saveSeat(seat);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }


        //        //Testing locking using thread
//        List<Seat> seatsToBeBooked = seatService.getListOfSeatsToBeBooked(bookingMovieJson.getLisOfSeatIdToBeBooked());
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
//                        UserDto temp = new UserDto();
//                        temp.setUserId(1);
//                        temp.setUserName("shivam");
//                        temp.setUserMobile(BigInteger.valueOf(8622035));
//
//                        for(Seat currentSeat:seatsToBeBooked)
//                        {
//                            Seat tempSeat = currentSeat;
//                            tempSeat.setIsReserved(1);
//                            tempSeat.setReservedByUser(userConverter.userDtoToEntity(temp));
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
//                        tempSeat.setIsReserved(1);
//                        tempSeat.setReservedByUser(userConverter.userDtoToEntity(bookingMovieJson.getBookedOrReservedByUser()));
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
