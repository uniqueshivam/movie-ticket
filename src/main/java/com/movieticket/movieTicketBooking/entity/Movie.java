package com.movieticket.movieTicketBooking.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  ="id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "director")
    public String director;

    public Movie()
    {

    }

    public Movie(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
