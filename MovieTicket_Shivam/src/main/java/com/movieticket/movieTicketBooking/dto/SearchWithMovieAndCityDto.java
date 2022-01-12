package com.movieticket.movieTicketBooking.dto;

public class SearchWithMovieAndCityDto {

    private int audiId;
    private String audiName;
    private String theaterName;
    private String city;
    private int totalSeatAvailable;
    private String movieName;

    public int getAudiId() {
        return audiId;
    }

    public void setAudiId(int audiId) {
        this.audiId = audiId;
    }

    public String getAudiName() {
        return audiName;
    }

    public void setAudiName(String audiName) {
        this.audiName = audiName;
    }


    public void setTheaterName(String theaterNae) {
        this.theaterName = theaterNae;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalSeatAvailable() {
        return totalSeatAvailable;
    }

    public void setTotalSeatAvailable(int totalSeatAvailable) {
        this.totalSeatAvailable = totalSeatAvailable;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
