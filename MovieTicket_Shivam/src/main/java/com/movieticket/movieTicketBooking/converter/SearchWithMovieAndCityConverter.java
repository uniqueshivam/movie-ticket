package com.movieticket.movieTicketBooking.converter;

import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.dto.SearchWithMovieAndCityDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchWithMovieAndCityConverter {

    public SearchWithMovieAndCityDto convertAudiEntityToDto(Audi audi)
    {
//        ModelMapper mapper =new ModelMapper();
//        SearchWithMovieAndCityDto map = mapper.map(audi, SearchWithMovieAndCityDto.class);
//        return map;

        SearchWithMovieAndCityDto dto = new SearchWithMovieAndCityDto();
        dto.setAudiId(audi.getId());
        dto.setAudiName(audi.getName());
        dto.setTheaterName(audi.getTheater().getName());
        dto.setTotalSeatAvailable(audi.getTotalSeats());
        dto.setMovieName(audi.getMovie().getName());
        dto.setCity(audi.getTheater().getCity());
        return dto;
    }

    public List<SearchWithMovieAndCityDto> convertListOfAudiEntityToDto(List<Audi> audis)
    {
        return	audis.stream().map(x -> convertAudiEntityToDto(x)).collect(Collectors.toList());
    }

}
