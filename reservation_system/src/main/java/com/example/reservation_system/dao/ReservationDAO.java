package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Reservation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReservationDAO {

    @Insert("INSERT INTO reservation(id, sid, wid, createTime, state) VALUES(#{id}, #{sid}, #{wid}, #{createTime}, #{state})")
    int add(Reservation reservation);

    void delete(Integer wid, Long sid);

    @Select("SELECT * FROM reservation WHERE wid = #{wid}")
    List<Reservation> reservationListByWid(Integer wid);

    @Select("SELECT * FROM reservation WHERE wid = #{wid} AND id = #{id}")
    Reservation getReservationByRid(@Param("wid") int wid, @Param("id")int id);

    @Update("UPDATE reservation SET state = #{state} WHERE wid = #{wid} AND id = #{id}")
    int updateState(Reservation reservation);

    @Select("SELECT * FROM reservation")
    List<Reservation> listAll();

    /**
     *  根据学生手机号查询预约记录
     * @param id
     * @return
     */
    @Select("SELECT * FROM reservation WHERE sid = #{sid}")
    Reservation getReservationBySid(String sid);
}
