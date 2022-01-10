package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.entity.Seat;
import com.movieticket.movieTicketBooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/getAll")
    public List<Seat> getAllSeat()
    {
        return seatService.getAllSeat();
    }

    @PostMapping("/addNewSeat")
    public void addNew(@RequestBody Seat seat)
    {
        seatService.saveSeat(seat);
    }
}
