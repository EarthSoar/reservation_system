package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Admin;
import com.example.reservation_system.daomain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeDAO {
    @Select("select * from employee where id = #{id}")
    Employee getByEmployeeId(@Param("id") String id);

    @Insert("INSERT INTO employee(id, name, windowId, phoneNum, password)VALUES(#{id}, #{name}, #{windowId}, #{phoneNum}, #{password}) ")
    void addEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteById(String id);

    @Update("UPDATE employee SET windowId = #{windowId} WHERE id = #{id}")
    void update(Employee employee);

    @Select("SELECT * from employee WHERE id = #{id}")
    Employee getEmployeeById(String id);

    @Select("SELECT * FROM employee")
    List<Employee> listEmployee();
}
