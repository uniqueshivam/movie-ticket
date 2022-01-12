package com.movieticket.movieTicketBooking.converter;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatConverter {

    @Autowired
    private AudiConverter audiConverter;
    private SeatDto seatEntityToDto(Seat seat)
    {
        SeatDto dto = new SeatDto();
        dto.setId(seat.getId());
        dto.setIsBooked(seat.getIsbooked());
        dto.setPrice(seat.getPrice());
        dto.setAudiId(seat.getAudi().getId());
        return dto;

    }

    public List<SeatDto> listOfSeatEntityToListDto(List<Seat> seats)
    {
        return	seats.stream().map(x -> seatEntityToDto(x)).collect(Collectors.toList());
    }

}
