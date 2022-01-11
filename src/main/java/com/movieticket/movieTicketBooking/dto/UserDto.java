package com.movieticket.movieTicketBooking.dto;

import java.math.BigInteger;
import java.util.List;

public class UserDto {

    private int userId;
    private String userName;
    private BigInteger userMobile;
    private List<BookingDto> bookings;


    public List<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingDto> bookings) {
        this.bookings = bookings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigInteger getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(BigInteger userMobile) {
        this.userMobile = userMobile;
    }
}
