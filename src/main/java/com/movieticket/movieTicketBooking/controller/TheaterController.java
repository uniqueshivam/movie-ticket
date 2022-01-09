package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.entity.Theater;
import com.movieticket.movieTicketBooking.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/theater")
@RestController
public class TheaterController {

    @Autowired
    public TheaterService theaterService;


    @GetMapping("/getAll")
    public List<Theater> getAllTheater()
    {
        return theaterService.getallTheater();
    }

    @PostMapping("/newTheater")
    public void saveTheater(@RequestBody Theater theater)
    {
        theaterService.saveTheater(theater);
    }


}
