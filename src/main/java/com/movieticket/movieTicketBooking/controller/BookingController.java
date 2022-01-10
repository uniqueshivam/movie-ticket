package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.entity.Booking;
import com.movieticket.movieTicketBooking.service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private Bookingservice bookingservice;

    @PostMapping("/addNew")
    public void addNewBooking(@RequestBody Booking booking)
    {
        bookingservice.newBooking(booking);
    }

    @GetMapping("/getAll")
    public List<Booking> getAllBooking()
    {
        return bookingservice.getAllBooking();
    }

}
