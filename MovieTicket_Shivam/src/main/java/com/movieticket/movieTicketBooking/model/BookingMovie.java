package com.movieticket.movieTicketBooking.model;

import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.dto.UserDto;
import com.movieticket.movieTicketBooking.entity.user;

import java.util.List;

public class BookingMovie {

    private List<Integer> lisOfSeatIdToBeBooked;
    private int audiId;
    private int movieId;
    private UserDto bookedOrReservedByUser;

    public List<Integer> getLisOfSeatIdToBeBooked() {
        return lisOfSeatIdToBeBooked;
    }

    public void setLisOfSeatIdToBeBooked(List<Integer> lisOfSeatIdToBeBooked) {
        this.lisOfSeatIdToBeBooked = lisOfSeatIdToBeBooked;
    }

    public int getAudiId() {
        return audiId;
    }

    public void setAudiId(int audiId) {
        this.audiId = audiId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public UserDto getBookedOrReservedByUser() {
        return bookedOrReservedByUser;
    }

    public void setBookedOrReservedByUser(UserDto bookedOrReservedByUser) {
        this.bookedOrReservedByUser = bookedOrReservedByUser;
    }
}

