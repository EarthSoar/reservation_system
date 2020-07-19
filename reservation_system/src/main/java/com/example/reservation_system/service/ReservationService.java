package com.example.reservation_system.service;

import com.example.reservation_system.dao.ReservationDAO;
import com.example.reservation_system.daomain.Reservation;
import com.example.reservation_system.util.ReservationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationDAO;



    public Long doRervation(Integer wid, String sid){
        Reservation reservation = new Reservation();
        //根据某一个窗口的全部的预约记录，求出最后一条记录的 预约序号，加上1设置给下一条预约该窗口的记录。
        List<Reservation> reservationList = reservationDAO.reservationListByWid(wid);

        Long id = 0L;
        if(reservationList == null || reservationList.size() == 0){
            id = 0L;
        }else{
            id = reservationList.get(reservationList.size() - 1).getId();
        }

//        Long id = 0L;
//        if(reservationList != null && reservationList.size() > 0){
//            id = reservationList.get(reservationList.size() - 1).getId();
//        }

//        Long id = reservationList == null || reservationList.size() == 0  ? 0 : reservationList.get(reservationList.size() - 1).getId();
        reservation.setId(id + 1);//预约号

        reservation.setSid(sid);//手机号
        reservation.setWid(wid);//窗口号
        reservation.setCreateTime(new Date());
        reservation.setState(ReservationState.WAIT);

        System.out.println(reservation);

        reservationDAO.add(reservation);

        return id;
    }
    public void unRervation(Integer wid, Long sid){
        reservationDAO.delete(wid, sid);
    }

    public List<Reservation> reservationList(Integer wid){
        return reservationDAO.reservationListByWid(wid);
    }

    public List<Reservation> listAll(){
        return reservationDAO.listAll();
    }

    public boolean setSate(int wid, int rid,int sate) {
        Reservation reservation = reservationDAO.getReservationByRid(wid, rid);
        reservation.setState(sate);
        int a = reservationDAO.updateState(reservation);
        return a == 1;
    }

    /**
     * @param id    预约序号
     * @param wid   窗口号
     * @return
     */
    public Reservation getReservation(Integer wid, Integer id) {
        return reservationDAO.getReservationByRid(wid,id);
    }


    public Reservation getReservationBySid(String  id){
        return reservationDAO.getReservationBySid(id);
    }

}
