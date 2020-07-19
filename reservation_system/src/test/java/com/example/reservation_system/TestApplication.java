package com.example.reservation_system;

import com.example.reservation_system.dao.ReservationDAO;
import com.example.reservation_system.daomain.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TestApplication {
    @Resource
    ReservationDAO reservationDAO;

    @Test
    public void test(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
    @Test
    public void test1(){
        Reservation reservation = reservationDAO.getReservationByRid(1, 9);
        new ClassPathXmlApplicationContext();
        new AnnotationConfigApplicationContext();
        System.out.println(reservation);
    }
}
