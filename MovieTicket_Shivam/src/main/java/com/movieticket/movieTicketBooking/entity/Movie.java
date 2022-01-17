package com.movieticket.movieTicketBooking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  ="id")
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "director")
    public String director;


    @OneToMany(mappedBy = "movie")
    private List<Audi> listOfAudi;

    public Movie()
    {

    }

    public Movie(Integer id, String name, String director, List<Audi> listOfAudi) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.listOfAudi = listOfAudi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Audi> getListOfAudi() {
        return listOfAudi;
    }

    public void setListOfAudi(List<Audi> listOfAudi) {
        this.listOfAudi = listOfAudi;
    }
}
