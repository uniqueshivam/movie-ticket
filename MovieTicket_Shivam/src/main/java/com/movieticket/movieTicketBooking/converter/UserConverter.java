package com.movieticket.movieTicketBooking.converter;

import com.movieticket.movieTicketBooking.dto.UserDto;
import com.movieticket.movieTicketBooking.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {


    public UserDto userEntityToDto(user u)
    {
        UserDto userDto= new UserDto();
        userDto.setUserId(u.getId());
        userDto.setUserName(u.getName());
        userDto.setUserMobile(u.getMobile());
        return userDto;

    }

    public List<UserDto> listOfUserEntityToListDto(List<user> listOfuser)
    {
        return	listOfuser.stream().map(x -> userEntityToDto(x)).collect(Collectors.toList());
    }

    public user userDtoToEntity(UserDto userDto)
    {
        user tempUser = new user();
        tempUser.setId(userDto.getUserId());
        tempUser.setName(userDto.getUserName());
        tempUser.setMobile(userDto.getUserMobile());
        return tempUser;
    }



}
