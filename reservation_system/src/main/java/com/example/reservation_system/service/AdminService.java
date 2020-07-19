package com.example.reservation_system.service;

import com.example.reservation_system.dao.AdminDAO;
import com.example.reservation_system.daomain.Admin;
import com.example.reservation_system.exception.GlobalException;
import com.example.reservation_system.result.CodeMsg;
import com.example.reservation_system.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Willing
 * @date 2020/5/1
 */
@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    public static final String COOKI_NAME_TOKEN = "admin_token";

    public boolean checkLogin(String name, String pwd) {
        //判断手机号是否存在
        Admin user = adminDAO.getByUsername(name);
        if(user == null){
            return false;
        }
        //验证密码
        String dbPass = user.getPassword();

        if(!StringUtils.isEmpty(pwd) && pwd.equals(dbPass)) {
            return true;
        }
        return false;
    }

    public String login(HttpServletResponse response, Admin admin) {
        if(admin == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String username = admin.getUsername();
        String password = admin.getPassword();
        //判断手机号是否存在
        Admin user = adminDAO.getByUsername(username);
        if(user == null) {
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        if(!password.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        return token;
    }
}
