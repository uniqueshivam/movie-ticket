package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.BookingConverter;
import com.movieticket.movieTicketBooking.converter.SeatConverter;
import com.movieticket.movieTicketBooking.converter.UserConverter;
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
    @Autowired
    private UserConverter userConverter;

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

        Booking newBooking = new Booking();

        newBooking.setAudi(audiToBeBooked);
        //Not calculating the amount as of now, making it hard coded
        newBooking.setTotalAmount(5000.0);
        newBooking.setUserBooked(userConverter.userDtoToEntity(bookingMovieJson.getBookedOrReservedByUser()));
        newBooking.setMovie(movieToBeBooked);


        Booking bookedBooking = bookingservice.newBooking(newBooking);
        try {
            //getting the seats which need to be booked for using the version part of the optimistic locking

            List<Seat> seatsToBeBooked = seatService.getListOfSeatsToBeBooked(bookingMovieJson.getLisOfSeatIdToBeBooked());


            try {
                for (Seat currentSeat : seatsToBeBooked) {
                    if (currentSeat.getReservedByUser().getId() != bookingMovieJson.getBookedOrReservedByUser().getUserId()) {
                        throw new Exception("User not authorized to book the seats reserved by other user");
                    }
                    Seat tempSeat = currentSeat;
                    tempSeat.setIsBooked(1);
                    tempSeat.setBooking(newBooking);
                    seatService.saveSeat(tempSeat);
                }
                bookedBooking.setListOfSeats(seatsToBeBooked);
                seatService.removeReservedByUserAfterBooking(seatsToBeBooked);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                //deleting the booking id generated because booking wasn't successful
                bookingservice.deleteBookingById(bookedBooking.getBooking_id());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //removing the reservation
            seatService.reserveToggleSeat(bookingMovieJson.getLisOfSeatIdToBeBooked(), 0);
        }


        return bookedBooking.getBooking_id();
    }

}
