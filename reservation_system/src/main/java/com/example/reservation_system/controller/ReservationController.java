package com.example.reservation_system.controller;

import com.example.reservation_system.config.UserContext;
import com.example.reservation_system.daomain.Reservation;
import com.example.reservation_system.daomain.Student;
import com.example.reservation_system.daomain.Window;
import com.example.reservation_system.service.ReservationService;
import com.example.reservation_system.service.StudentService;
import com.example.reservation_system.service.WindowService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private WindowService windowService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/toReservation")
    public String toReseration(Model model, HttpServletRequest request){
        //在预约表中判断当前用户是否已经预约过了。
        Student student = (Student) request.getSession().getAttribute("STUDNET_IN_SESSION");
        System.out.println(student);

        Reservation reservationById = reservationService.getReservationBySid(student.getId());
        if(reservationById != null){
            //已经预约过了，将按钮隐藏掉
            model.addAttribute("butto", -1);
        }else {
            model.addAttribute("butto", 1);
        }
        List<Window> windowList = windowService.getAll();
        model.addAttribute("winList",windowList);
        return "mobile/reservation";
    }


    @RequestMapping("/toDetial")
    public String toDetial(@RequestParam("wid") Integer wid, @RequestParam("sid")String sid, Model model){
        Window win = windowService.getWindowById(wid);
        model.addAttribute("student",studentService.getStudentByPhone(sid));
        model.addAttribute("window", win);
        return "/mobile/detail";
    }

    @RequestMapping("/doReservation")
    public String doReservation(@RequestParam("wid") Integer wid, @RequestParam("sid")String sid, Model model){
        Window win = windowService.getWindowById(wid);
        model.addAttribute("student",studentService.getStudentByPhone(sid));
        model.addAttribute("window", win);

        //如果当前最大可以预约的窗口数目是0了，说明已经不能预约了，直接跳转到
        if(win.getMaxCount() < 1){
            model.addAttribute("result","该窗口预约达上限!!!");
            return "/mobile/detail";
        }
        win.setMaxCount(win.getMaxCount() - 1);
        win.setWaitCount(win.getWaitCount() + 1);

        System.out.println(win);
        windowService.updateWindow(win);
        //将预约记录到  预约表 ,返回预约号
        Long id = reservationService.doRervation(wid, sid);
        if (id == null){
            model.addAttribute("msg", "预约失败,稍后再试");
            //return "redirect:" + "/reservation/detail";
            return "error";
        }
        model.addAttribute("result","预约成功!!!, 您的号码是" + id);
        return "/mobile/detail";
    }

    @RequestMapping("/unReservation")
    public void un(@RequestParam("wid") Integer wid, Long sid){
        Window win = windowService.getWindowById(wid);
        if(win.getWaitCount() < 1){
            return;
        }
        win.setMaxCount(win.getMaxCount() + 1);
        win.setWaitCount(win.getWaitCount() - 1);
        windowService.updateWindow(win);

        reservationService.unRervation(wid, sid);
    }
}
