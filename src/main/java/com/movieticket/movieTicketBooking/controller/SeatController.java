package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.SeatConverter;
import com.movieticket.movieTicketBooking.dto.SeatDto;
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
    @Autowired
    private SeatConverter seatConverter;

    @GetMapping("/getAll")
    public List<SeatDto> getAllSeat()
    {

        return seatConverter.listOfSeatEntityToListDto(seatService.getAllSeat());
    }

    @PostMapping("/addNewSeat")
    public void addNew(@RequestBody Seat seat)
    {
        System.out.println("########################################################");
        System.out.println(seat);

        seatService.saveSeat(seat);
    }
}
