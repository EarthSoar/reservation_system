package com.example.reservation_system.controller;

import com.example.reservation_system.daomain.Employee;
import com.example.reservation_system.daomain.Evaluate;
import com.example.reservation_system.daomain.Reservation;
import com.example.reservation_system.service.AdminService;
import com.example.reservation_system.service.EmployeeService;
import com.example.reservation_system.service.EvaluateService;
import com.example.reservation_system.service.ReservationService;
import org.apache.commons.lang3.reflect.InheritanceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Willing
 * @date 2020/5/1
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EvaluateService evaluateService;


    @RequestMapping("/tologin")
    public String toLogin(){
        return "aelogin";
    }

    @PostMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("pwd") String pwd,@RequestParam("status") String status, Model model) {
        if(status.equals("1")){
            //检查管理员的用户名和密码是否正确
            boolean result = adminService.checkLogin(name, pwd);
            if (result) {
                model.addAttribute("name", name);
                model.addAttribute("pwd", pwd);
                //跳转到 管理员 的首页
                return "admin-index";
            }
        }
        if(status.equals("2")){
            //检查员工的用户名和密码是否正确
            Employee employee = employeeService.checkLogin(name, pwd);
            if (employee != null) {
                model.addAttribute("employee", employee);
                return "employee-index";
            }
        }
        return "aelogin";
    }

    @RequestMapping("/reservationList")
    public String reservationList(Model model){
        List<Reservation> reservations = reservationService.listAll();
        System.out.println(reservations);
        model.addAttribute("reservations", reservations);
        return "list-reservation2";
    }

    @RequestMapping("/evaluate")
    public String listContent(Model model){
        List<Evaluate> evaluates = evaluateService.listInfo();
        System.out.println(evaluates);
        model.addAttribute("evaluates", evaluates);
        return "list-evaluate";
    }

}
