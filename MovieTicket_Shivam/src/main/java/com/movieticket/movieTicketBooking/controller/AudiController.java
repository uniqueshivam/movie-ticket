package com.movieticket.movieTicketBooking.controller;


import com.movieticket.movieTicketBooking.converter.AudiConverter;
import com.movieticket.movieTicketBooking.dto.AudiDto;
import com.movieticket.movieTicketBooking.entity.Audi;
import com.movieticket.movieTicketBooking.service.AudiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/audi")
@RestController
public class AudiController {

    @Autowired
    public AudiService audiService;
    @Autowired
    private AudiConverter audiConverter;

    @GetMapping("/allAudi")
    public List<AudiDto> getAllAudi()
    {

        return audiConverter.listOfAudiEntityToListDto(audiService.getAllAudi());
    }

    @PostMapping("/newAudi")
    public void saveAudi(@RequestBody Audi audi)
    {
        audiService.addAudi(audi);
    }

    @GetMapping("/getAudi/{id}")
    public AudiDto getAudiById(@PathVariable int id)
    {
        return audiConverter.audiEntityToDto( audiService.getAudiById(id));
    }

    @DeleteMapping("/deleteAudi/{id}")
    public int deleteAudi(@PathVariable int id)
    {
        return audiService.deleteAudiById(id);
    }

    @GetMapping("/searchWithMovieAndCity/{movieName}/{cityName}")
    public List<AudiDto> searchWithMovieAndCity(@PathVariable String movieName, @PathVariable  String cityName)
    {
        return audiConverter.listOfAudiEntityToListDto(audiService.findAudiByMovieAndCity(movieName,cityName));
    }
}
