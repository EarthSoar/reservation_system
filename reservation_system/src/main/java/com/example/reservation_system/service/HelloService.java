package com.example.reservation_system.service;

import com.example.reservation_system.dao.HelloDAO;
import com.example.reservation_system.daomain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HelloService {
    @Autowired
    private HelloDAO helloDAO;

    public void insert(Admin admin){
        helloDAO.add(admin);
    }


    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setUsername("username");
        admin.setPassword("password");
        new HelloService().insert(admin);
    }

}
