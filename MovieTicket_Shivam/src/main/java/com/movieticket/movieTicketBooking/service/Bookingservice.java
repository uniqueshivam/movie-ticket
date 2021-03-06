package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Booking;
import com.movieticket.movieTicketBooking.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class Bookingservice {
    @Autowired
    private BookingRepo bookingRepo;


    public Booking newBooking(Booking booking)
    {
        return  bookingRepo.saveAndFlush(booking);
    }

    public List<Booking> getAllBooking()
    {

        return bookingRepo.findAll();
    }

    public Booking getBookingById(int id)
    {
        return bookingRepo.findById(id).get();
    }

    public int deleteBookingById(int id)
    {
        bookingRepo.deleteById(id);
        return id;
    }
}
