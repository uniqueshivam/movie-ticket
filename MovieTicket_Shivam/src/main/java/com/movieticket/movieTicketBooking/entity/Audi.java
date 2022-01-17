package com.movieticket.movieTicketBooking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="audi")
public class Audi {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "totalseats")
    public Integer totalSeats;
    @Column(name = "name")
    public String name;

    @ManyToOne
    @JoinColumn(name = "movieid",referencedColumnName = "id")
    public Movie movie;

    @ManyToOne
    @JoinColumn(name = "theaterid",referencedColumnName = "id")
    public Theater theater;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "audi",cascade = CascadeType.ALL)
    public List<Seat> seats;


    public Audi()
    {

    }

    public Audi(Integer id, Integer totalSeats, String name, Movie movie, Theater theater, List<Seat> seats) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.name = name;
        this.movie = movie;
        this.theater = theater;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Audi{" +
                "id=" + id +
                ", totalSeats=" + totalSeats +
                ", name='" + name + '\'' +
                ", movie=" + movie +
                ", theater=" + theater +
                ", seats=" + seats +
                '}';
    }
}
