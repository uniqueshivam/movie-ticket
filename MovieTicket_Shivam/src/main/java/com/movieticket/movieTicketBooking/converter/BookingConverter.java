package com.movieticket.movieTicketBooking.converter;


import com.movieticket.movieTicketBooking.dto.BookingDto;
import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.entity.Booking;
import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingConverter {

    @Autowired
    private SeatConverter seatConverter;
    @Autowired
    private UserConverter userConverter;

    public BookingDto bookingEntityToDto(Booking booking)
    {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getBooking_id());
        bookingDto.setAudiName(booking.getAudi().getName());
        bookingDto.setMovieName(booking.getMovie().getName());
        bookingDto.setBookingTime(booking.getBookingTime());
        bookingDto.setUserBooked(userConverter.userEntityToDto(booking.getUserBooked()));
        bookingDto.setSeats(seatConverter.listOfSeatEntityToListDto(booking.getListOfSeats()));

        return bookingDto;
    }

    public List<BookingDto> listOfBookingEntityToListDto(List<Booking> bookings)
    {
        return	bookings.stream().map(x -> bookingEntityToDto(x)).collect(Collectors.toList());
    }

}
