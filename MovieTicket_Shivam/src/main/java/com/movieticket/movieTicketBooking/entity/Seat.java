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
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "audiid")
    public Audi audi;

    @Column(name = "isbooked")
    public Integer isBooked;

    @Column(name = "price")
    public Integer price;

    @Version
    @Column(name = "version")
    @Value("${some.key:0}")
    public Integer version=0;

    @Column(name = "is_reserved")
    @Value("${some.key:0}")
    public Integer isReserved=0;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "reserved_by_user_id",referencedColumnName = "id")
    private user reservedByUser;



    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name ="booking_id")
    public Booking booking;


    public Seat()
    {

    }

    public Seat(Integer id, Audi audi, Integer isBooked, Integer price, Integer version, Integer isReserved, user reservedByUser, Booking booking) {
        this.id = id;
        this.audi = audi;
        this.isBooked = isBooked;
        this.price = price;
        this.version = version;
        this.isReserved = isReserved;
        this.reservedByUser = reservedByUser;
        this.booking = booking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public Integer getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Integer isBooked) {
        this.isBooked = isBooked;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Integer isReserved) {
        this.isReserved = isReserved;
    }

    public user getReservedByUser() {
        return reservedByUser;
    }

    public void setReservedByUser(user reservedByUser) {
        this.reservedByUser = reservedByUser;
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
