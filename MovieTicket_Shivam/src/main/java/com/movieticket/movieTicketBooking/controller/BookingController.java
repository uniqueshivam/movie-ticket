package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.BookingConverter;
import com.movieticket.movieTicketBooking.dto.BookingDto;
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
    @Autowired
    private BookingConverter bookingConverter;

    @PostMapping("/addNew")
    public void addNewBooking(@RequestBody Booking booking)
    {
        bookingservice.newBooking(booking);
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

}
