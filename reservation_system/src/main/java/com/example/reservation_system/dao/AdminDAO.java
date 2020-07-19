package com.example.reservation_system.dao;

import com.example.reservation_system.daomain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Willing
 * @date 2020/5/1
 */
@Mapper
public interface AdminDAO {
    @Select("select username, password from admin where username = #{username}")
    Admin getByUsername(@Param("username") String username);
}
