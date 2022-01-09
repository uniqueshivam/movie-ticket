package com.movieticket.movieTicketBooking.entity;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "user")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "mobile")
    public BigInteger mobile;


    public user()
    {

    }

    public user(int id, String name, BigInteger mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }
}
