package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Mapper
public interface PoorStudentDAO {

    @Select("SELECT id, openId, name, sex FROM poor_student WHERE cardId = #{cardId}")
    Student getStudentByCard(@Param("cardId") String cardId);
}
