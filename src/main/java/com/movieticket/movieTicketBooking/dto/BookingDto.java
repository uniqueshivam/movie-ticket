package com.movieticket.movieTicketBooking.dto;

import java.util.Date;
import java.util.List;

public class BookingDto {

    private int bookingId;
    private String audiName;
    private String movieName;
    private Date bookingTime;

    private List<SeatDto> seats;


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public List<SeatDto> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDto> seats) {
        this.seats = seats;
    }
}
