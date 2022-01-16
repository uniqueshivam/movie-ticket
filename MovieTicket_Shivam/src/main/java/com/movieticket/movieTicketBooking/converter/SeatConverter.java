package com.movieticket.movieTicketBooking.converter;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.SecondaryTable;
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
        dto.setIsBooked(seat.getIsBooked());
        dto.setPrice(seat.getPrice());
        dto.setAudiId(seat.getAudi().getId());
        return dto;

    }

    public List<SeatDto> listOfSeatEntityToListDto(List<Seat> seats)
    {
        return	seats.stream().map(x -> seatEntityToDto(x)).collect(Collectors.toList());
    }

    public Seat seatDtoToEntity(SeatDto seatDto)
    {
        Seat seat = new Seat();
        seat.setId(seatDto.getId());
        seat.setPrice(seatDto.getPrice());
        Audi tempAudi = new Audi();
        tempAudi.setId(seatDto.getId());
        seat.setAudi(tempAudi);
        seat.setIsBooked(1);

        return seat;
    }

    public List<Seat> listOfSeatDtoToSeat(List<SeatDto> seatDtos)
    {
        return	seatDtos.stream().map(x -> seatDtoToEntity(x)).collect(Collectors.toList());
    }

}
