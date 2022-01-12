package com.movieticket.movieTicketBooking.service;

import com.movieticket.movieTicketBooking.entity.user;
import com.movieticket.movieTicketBooking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public List<user> getAlluser()
    {
        return userRepo.findAll();
    }

    public void saveuser(user newuser)
    {
        userRepo.save(newuser);
    }
}
