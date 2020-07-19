package com.example.reservation_system.controller;

import com.example.reservation_system.daomain.Employee;
import com.example.reservation_system.daomain.Reservation;
import com.example.reservation_system.daomain.Window;
import com.example.reservation_system.service.EmployeeService;
import com.example.reservation_system.service.ReservationService;
import com.example.reservation_system.service.StudentService;
import com.example.reservation_system.service.WindowService;
import com.example.reservation_system.util.ReservationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private WindowService windowService;
    @Autowired
    private ReservationService reservationService;
    @Resource
    private StudentService studentService;

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/getAllEmployee";
    }

    @RequestMapping("/getAllEmployee")
    public String listEmployee(Model model){
        List<Employee> employees = employeeService.listEmployee();
        model.addAttribute("employees",employees);
        return "list-employee";
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam("id") String id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/getAllEmployee";
    }

    @RequestMapping("/updateById")
    public String updateById(String id, Model model){
        Employee employee  = employeeService.getByEmployeeId(id);
        List<Window> winds = windowService.getAll();
        model.addAttribute("winds",winds);
        model.addAttribute("employee", employee);
        return "update-employee";
    }
    @RequestMapping("/dpupdate")
    public String doUpdate(Employee employee){
        employeeService.update(employee);
        return "redirect:/employee/getAllEmployee";
    }
//------------------------------------------------------------------
    @RequestMapping("/reservationList")
    public String reservationList(@RequestParam("windowId") Integer wid, Model model){
        List<Reservation> reservations = reservationService.reservationList(wid);
        System.out.println(reservations);
        model.addAttribute("reservations", reservations);
        return "list-reservation";
    }

    @RequestMapping("/handle")
    public String ing(@RequestParam("rid") Integer rid, @RequestParam("wid") Integer wid, Model model){
        //1、修改预约状态
        boolean res = reservationService.setSate(wid, rid,ReservationState.WORKING);
        //2、设置窗口服务id
        windowService.setServerId(wid, rid);

        //获取当前处理的预约对象
        Reservation reservation = reservationService.getReservation(wid, rid);

        model.addAttribute("reservation",reservation);
        return "handle";
    }

    //点击处理完成
    @RequestMapping("/finish")
    public String finish(@RequestParam("rid") Integer rid, @RequestParam("wid") Integer wid){
        reservationService.setSate(wid, rid, ReservationState.FINISH);
        //将等待人数减少1
        Window window = windowService.getWindowById(wid);
        window.setWaitCount(window.getWaitCount() - 1);
        windowService.updateWindow(window);
        return "redirect:/employee/reservationList" + "?windowId=" + wid;
    }

    //-------修改个人信息

    /**
     * @param id  员工id
     * @return
     */
    @RequestMapping("/edit")
    public String editInfo(@RequestParam("id") String id, Model model){
        Employee employee = employeeService.getByEmployeeId(id);
        model.addAttribute("employee", employee);
        return "employee-edit";
    }


    @RequestMapping("/update")
    public String updateInfo(@RequestParam("id") String id, Model model){
        Employee employee = employeeService.getByEmployeeId(id);
        model.addAttribute("employee", employee);
        return "employee-update";
    }
}
