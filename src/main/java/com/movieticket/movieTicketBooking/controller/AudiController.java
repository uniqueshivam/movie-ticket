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
}
