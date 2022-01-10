package com.movieticket.movieTicketBooking.dto;

public class SeatDto {

    private int id;
    private AudiDto audiDto;
    private int isBooked;
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AudiDto getAudiDto() {
        return audiDto;
    }

    public void setAudiDto(AudiDto audiDto) {
        this.audiDto = audiDto;
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
}
