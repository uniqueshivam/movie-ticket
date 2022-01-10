package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.Booking;
import com.movieticket.movieTicketBooking.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.ArrayList;
import java.util.List;

@Service
public class Bookingservice {
    @Autowired
    private BookingRepo bookingRepo;


    public void newBooking(Booking booking)
    {
        bookingRepo.save(booking);
    }

    public List<Booking> getAllBooking()
    {
        System.out.println("*****************************************************");
        System.out.println(bookingRepo.findAll().get(0));
        return bookingRepo.findAll();
    }
}
