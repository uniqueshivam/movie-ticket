package com.movieticket.movieTicketBooking.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@DynamicUpdate
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatid")
    public int id;

    @ManyToOne
    @JoinColumn(name = "audiid")
    public Audi audi;

    @Column(name = "isbooked")
    public int isBooked;

    @Column(name = "price")
    public int price;

    @Version
    @Column(name = "version")
    @Value("${some.key:0}")
    public int version=0;

    @Column(name = "is_reserved")
    @Value("${some.key:0}")
    public int isReserved=0;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="booking_id")
    public Booking booking;


    public Seat()
    {

    }

    public Seat(int id, Audi audi, int isBooked, int price, int version, int isReserved, Booking booking) {
        this.id = id;
        this.audi = audi;
        this.isBooked = isBooked;
        this.price = price;
        this.version = version;
        this.isReserved = isReserved;
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

    public int getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(int isBooked) {
        this.isBooked = isBooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int isReserved() {
        return isReserved;
    }

    public void setReserved(int reserved) {
        isReserved = reserved;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", audi=" + audi +
                ", isBooked=" + isBooked +
                ", price=" + price +
                ", booking=" + booking +
                '}';
    }
}
