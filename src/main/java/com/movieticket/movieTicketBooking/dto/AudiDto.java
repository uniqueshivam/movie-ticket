package com.movieticket.movieTicketBooking.dto;

public class AudiDto {

    private int id;
    private int totalSeats;
    private String name;
    private String movieName;
    private String theaterName;
    private String city;


    public AudiDto()
    {

    }

    public AudiDto(int id, int totalSeats, String name, String movieName, String theaterName, String city) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.name = name;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.city = city;
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
