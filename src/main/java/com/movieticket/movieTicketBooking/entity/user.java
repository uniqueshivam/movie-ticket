package com.movieticket.movieTicketBooking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "user")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "mobile")
    public BigInteger mobile;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userBooked",cascade = CascadeType.ALL)
    public List<Booking> bookings;

    public user()
    {

    }

    public user(int id, String name, BigInteger mobile, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }
}
