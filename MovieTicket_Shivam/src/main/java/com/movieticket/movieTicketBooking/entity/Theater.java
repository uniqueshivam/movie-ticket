package com.movieticket.movieTicketBooking.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "city")
    public String city;

    @OneToMany(mappedBy = "theater")
    private List<Audi> listOfAudi;

    public Theater()
    {

    }

    public Theater(Integer id, String name, String city, List<Audi> listOfAudi) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.listOfAudi = listOfAudi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Audi> getListOfAudi() {
        return listOfAudi;
    }

    public void setListOfAudi(List<Audi> listOfAudi) {
        this.listOfAudi = listOfAudi;
    }
}
