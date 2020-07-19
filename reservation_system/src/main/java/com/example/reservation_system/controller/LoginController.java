package com.example.reservation_system.controller;

import com.example.reservation_system.config.UserContext;
import com.example.reservation_system.daomain.Student;
import com.example.reservation_system.result.Result;
import com.example.reservation_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "mobile/login";
    }

    @PostMapping("/authentication")
    public String login(Student student, HttpServletRequest request, Model model){
        System.out.println(student);
        boolean authres = studentService.authentication(student, request);
        if (authres == false){
            model.addAttribute("loginResult", "认证失败，请拿相关资料去学生资助中心去认证");
            return "mobile/login";
        }
        return "redirect:/reservation/toReservation";
    }
}
