package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Evaluate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvaluateDAO {

    @Insert("INSERT INTO evaluate(id, name, windowId, content, score) VALUES(#{id}, #{name}, #{windowId}, #{content}, #{score})")
    void add(Evaluate evaluate);

    @Select("SELECT * FROM evaluate")
    List<Evaluate> listAll();
}
