package com.movieticket.movieTicketBooking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

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
    public boolean isbooked;
    @Column(name = "price")
    public int price;


    public Seat()
    {

    }

    public Seat(int id, Audi audi, boolean isbooked, int price) {
        this.id = id;
        this.audi = audi;
        this.isbooked = isbooked;
        this.price = price;
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

    public boolean isIsbooked() {
        return isbooked;
    }

    public void setIsbooked(boolean isbooked) {
        this.isbooked = isbooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
