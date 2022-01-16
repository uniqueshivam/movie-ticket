package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.BookingConverter;
import com.movieticket.movieTicketBooking.converter.SeatConverter;
import com.movieticket.movieTicketBooking.dto.BookingDto;
import com.movieticket.movieTicketBooking.entity.*;
import com.movieticket.movieTicketBooking.model.BookingMovie;
import com.movieticket.movieTicketBooking.service.Bookingservice;
import com.movieticket.movieTicketBooking.service.SeatService;
import org.apache.catalina.User;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private Bookingservice bookingservice;
    @Autowired
    private BookingConverter bookingConverter;
    @Autowired
    private SeatService seatService;

    @PostMapping("/addNew")
    public int addNewBooking(@RequestBody Booking booking) {
        return bookingservice.newBooking(booking).getBooking_id();
    }

    @GetMapping("/getAll")
    public List<BookingDto> getAllBooking() {

        return bookingConverter.listOfBookingEntityToListDto(bookingservice.getAllBooking());
    }

    @GetMapping("/getBooking/{id}")
    public BookingDto getBookingById(@PathVariable int id) {
        return bookingConverter.bookingEntityToDto(bookingservice.getBookingById(id));
    }

    @DeleteMapping("/deleteBooking/{id}")
    public int deleteBookingById(@PathVariable int id) {
        return bookingservice.deleteBookingById(id);
    }

    @PostMapping("/bookSeats")
    public int bookSeats(@RequestBody BookingMovie bookingMovieJson) {
        Movie movieToBeBooked = new Movie();
        movieToBeBooked.setId(bookingMovieJson.getMovieId());

        Audi audiToBeBooked = new Audi();
        audiToBeBooked.setId(bookingMovieJson.getAudiId());

        user userBooking = new user();
        userBooking.setId(1);

        Booking newBooking = new Booking();

        newBooking.setAudi(audiToBeBooked);
        newBooking.setTotalAmount(5000);
        newBooking.setUserBooked(userBooking);
        newBooking.setMovie(movieToBeBooked);

        int bookingId = -1;

        //reserving the seats for the booking
        try {
            Booking bookedBooking = bookingservice.newBooking(newBooking);
            bookingId = bookedBooking.getBooking_id();
            seatService.reserveToggleSeat(bookingMovieJson.getLisOfSeatIdToBeBooked(), 1);

            //getting the seats which need to be booked for using the version part of the optimistic locking
            List<Seat> seatsToBeBooked = seatService.forLockingTheSeats(bookingMovieJson.getLisOfSeatIdToBeBooked());


            try {
                for (Seat currentSeat : seatsToBeBooked) {
                    Seat tempSeat = currentSeat;
                    tempSeat.setIsBooked(1);
                    tempSeat.setBooking(newBooking);
                    seatService.saveSeat(tempSeat);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //deleting the booking Id generated
                bookingservice.deleteBookingById(bookedBooking.getBooking_id());
            }


            //Testing locking using thread
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
//                            tempSeat.setBooking(newBooking);
//                            seatService.saveSeat(tempSeat);
//                        }
//                    }
//                    catch (Exception e)
//                    {
//                        System.out.println(e.getMessage());
////                        bookingservice.deleteBookingById(bookedBooking.getBooking_id());
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
//                        tempSeat.setBooking(newBooking);
//                        seatService.saveSeat(tempSeat);
//                    }
//
//                }
//            };
//
//            new Thread(t).start();
//            new Thread(t2).start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //removing the reservation
            seatService.reserveToggleSeat(bookingMovieJson.getLisOfSeatIdToBeBooked(), 0);
        }


        return bookingId;
    }

}
