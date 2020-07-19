package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Willing
 * @date 2020/4/6
 */
@Mapper
public interface StudentDAO {

    @Insert("INSERT INTO student(id, openId, name, sex, cardId) VALUES(#{id}, #{openId}, #{name}, #{sex}, #{cardId})")
    void save(Student student);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(String id);

    @Select("SELECT * FROM student WHERE cardId = #{cardId}")
    Student getByCardId(String cardId);

    @Select("SELECT * FROM student")
    List<Student> listAll();

//
//    void getStudentList();
//
//    void delStudentById(Long id);
//
//    void updateStudent(Student student);
}


