package com.movieticket.movieTicketBooking.controller;


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

    @GetMapping("/allAudi")
    public List<Audi> getAllAudi()
    {
        return audiService.getAllAudi();
    }

    @PostMapping("/newAudi")
    public void saveAudi(@RequestBody Audi audi)
    {
        System.out.println("*****************************************************");
        System.out.println(audi);

        audiService.addAudi(audi);
    }
}
