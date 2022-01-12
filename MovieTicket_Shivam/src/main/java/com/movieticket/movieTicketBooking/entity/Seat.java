package com.movieticket.movieTicketBooking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatid")
    public int id;

    @ManyToOne
    @JoinColumn(name = "audiid")
    public Audi audi;

    @Column(name = "isbooked")
    public int isbooked;

    @Column(name = "price")
    public int price;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="booking_id")
    public Booking booking;


    public Seat()
    {

    }

    public Seat(int id, Audi audi, int isbooked, int price, Booking booking) {
        this.id = id;
        this.audi = audi;
        this.isbooked = isbooked;
        this.price = price;
        this.booking = booking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public int getIsbooked() {
        return isbooked;
    }

    public void setIsbooked(int isbooked) {
        this.isbooked = isbooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }


}