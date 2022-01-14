package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.BookingConverter;
import com.movieticket.movieTicketBooking.converter.SeatConverter;
import com.movieticket.movieTicketBooking.dto.BookingDto;
import com.movieticket.movieTicketBooking.entity.*;
import com.movieticket.movieTicketBooking.model.BookingMovie;
import com.movieticket.movieTicketBooking.service.Bookingservice;
import com.movieticket.movieTicketBooking.service.SeatService;
import org.apache.catalina.User;
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
    public int  addNewBooking(@RequestBody Booking booking)
    {
        return bookingservice.newBooking(booking).getBooking_id();
    }

    @GetMapping("/getAll")
    public List<BookingDto> getAllBooking()
    {

        return bookingConverter.listOfBookingEntityToListDto(bookingservice.getAllBooking());
    }

    @GetMapping("/getBooking/{id}")
    public BookingDto getBookingById(@PathVariable int id)
    {
        return bookingConverter.bookingEntityToDto(bookingservice.getBookingById(id));
    }

    @DeleteMapping("/deleteBooking/{id}")
    public int deleteBookingById(@PathVariable int id)
    {
        return bookingservice.deleteBookingById(id);
    }

    @PostMapping("/bookSeats")
    public int bookSeats(@RequestBody BookingMovie bookingMovieJson)
    {
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

        Booking bookedBooking = bookingservice.newBooking(newBooking);
        seatService.forLockingTheSeats(bookingMovieJson.getLisOfSeatIdToBeBooked());
        seatService.updateMultipleSeatsWithBookingId(bookedBooking.getBooking_id(),bookingMovieJson.getLisOfSeatIdToBeBooked());

        return bookedBooking.getBooking_id();
    }

}
