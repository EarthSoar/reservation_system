package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Window;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WindowDAO {
    @Insert("INSERT INTO window(id,openTime,closeTime,currentSid,waitCount,maxCount) VALUES(#{id},#{openTime},#{closeTime},#{currentSid},#{waitCount},#{maxCount})")
    int add(Window window);

    @Delete("DELETE FROM window WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE window SET maxCount = #{maxCount}, waitCount = #{waitCount}, currentSid = #{currentSid} WHERE id = #{id}")
    void update(Window window);

    @Select("SELECT * FROM window WHERE id = #{id}")
    Window getById(Integer id);

    @Select("SELECT * FROM window")
    List<Window> listAll();

    List<Window> getAll(Integer pageNum, Integer pageSize);
}
