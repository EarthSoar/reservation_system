package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloDAO {
    @Insert("INSERT INTO admin(username, password) VALUES(#{username},#{password})")
    void add(Admin admin);
}
