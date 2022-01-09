package com.movieticket.movieTicketBooking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="audi")
public class Audi {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "totalseats")
    public int totalSeats;
    @Column(name = "name")
    public String name;
    @ManyToOne
    @JoinColumn(name = "movieid")
    public Movie movie;
    @ManyToOne
    @JoinColumn(name = "theaterid")
    public Theater theater;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "audi",cascade = CascadeType.ALL)
    public List<Seat> seats;




    public Audi()
    {

    }

    public Audi(int id, int totalSeats, String name, Movie movie, Theater theater) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.name = name;
        this.movie = movie;
        this.theater = theater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
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
}
