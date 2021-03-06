package com.movieticket.movieTicketBooking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer booking_id;

    @ManyToOne
    @JoinColumn(name = "audi_id",referencedColumnName = "id")
    private Audi audi;

    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "id")
    private Movie movie;

    @Column(name ="booking_time")
    private Date bookingTime;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "booking",cascade = CascadeType.ALL)
    private List<Seat> listOfSeats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private user userBooked;

    public Booking()
    {

    }


    public Booking(Integer booking_id, Audi audi, Movie movie, Date bookingTime, Double totalAmount, List<Seat> listOfSeats, user userBooked) {
        this.booking_id = booking_id;
        this.audi = audi;
        this.movie = movie;
        this.bookingTime = bookingTime;
        this.totalAmount = totalAmount;
        this.listOfSeats = listOfSeats;
        this.userBooked = userBooked;
    }

    public Integer getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(Integer booking_id) {
        this.booking_id = booking_id;
    }

    public Audi getAudi() {
        return audi;
    }

    public void setAudi(Audi audi) {
        this.audi = audi;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Seat> getListOfSeats() {
        return listOfSeats;
    }

    public void setListOfSeats(List<Seat> listOfSeats) {
        this.listOfSeats = listOfSeats;
    }

    public user getUserBooked() {
        return userBooked;
    }

    public void setUserBooked(user userBooked) {
        this.userBooked = userBooked;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", audi=" + audi +
                ", movie=" + movie +
                ", bookingTime=" + bookingTime +
                ", totalAmount=" + totalAmount +
                ", listOfSeats=" + listOfSeats +
                ", userBooked=" + userBooked +
                '}';
    }
}
