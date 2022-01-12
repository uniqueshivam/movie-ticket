package com.movieticket.movieTicketBooking.controller;

import com.movieticket.movieTicketBooking.converter.UserConverter;
import com.movieticket.movieTicketBooking.dto.UserDto;
import com.movieticket.movieTicketBooking.entity.user;
import com.movieticket.movieTicketBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    private UserConverter userConverter;

    @PostMapping("/newUser")
    public void addNewUser(@RequestBody user newUser)
    {
        userService.saveuser(newUser);
    }

    @GetMapping("/allUser")
    public List<UserDto> getAllUser()
    {
        System.out.println("hii");
        return userConverter.listOfUserEntityToListDto( userService.getAlluser());
    }
}
