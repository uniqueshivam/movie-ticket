package com.movieticket.movieTicketBooking.converter;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.SeatDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AudiConverter {

    public AudiDto audiEntityToDto(Audi audi)
    {
        AudiDto audiDto = new AudiDto();
        audiDto.setId(audi.getId());
        audiDto.setName(audi.getName());
        audiDto.setMovieName(audi.getMovie().getName());
        audiDto.setTheaterName(audi.getTheater().getName());
        audiDto.setTotalSeats(audi.getTotalSeats());

        return audiDto;

    }

    public List<AudiDto> listOfAudiEntityToListDto(List<Audi> audis)
    {
        return	audis.stream().map(x -> audiEntityToDto(x)).collect(Collectors.toList());
    }

//    public Audi audiDtoToEntity(AudiDto audiDto)
//    {
//        Audi audi = new Audi();
//        audi.setId(audiDto.getId());
//        audi.setName(audiDto.getName());
//        audi.setTotalSeats(audiDto.getTotalSeats());
//        audi.setMovie();
//
//    }
}
