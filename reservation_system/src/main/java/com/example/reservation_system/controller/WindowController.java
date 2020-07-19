package com.example.reservation_system.controller;

import com.example.reservation_system.daomain.Window;
import com.example.reservation_system.service.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/window")
public class WindowController {
    @Autowired
    private WindowService windowService;

    @RequestMapping("/toaddWindow")
    public String addWindow(){
        return "add-window";
    }
    @RequestMapping("/doaddWindow")
    public String doaddWindow(@RequestParam("wid") Integer wid, @RequestParam(value = "openTime",required = false) String openTime, @RequestParam(value = "closeTime",required = false) String closeTime, @RequestParam("maxCount") Integer maxCount){
        Window window = new Window();
        window.setId(wid);
        if (!StringUtils.isEmpty(openTime)){
            window.setOpenTime(openTime);
        }
        if (!StringUtils.isEmpty(closeTime)){
            window.setCloseTime(closeTime);
        }
        window.setCurrentSid(-1);
        window.setWaitCount(0);
        window.setMaxCount(maxCount);
        System.out.println(window);
        windowService.addWindow(window);
        return "redirect:/window/getWindow";
    }
    @RequestMapping("/getWindow")
    public String listWindow(Model model){
        //PageHelper.startPage(pageNum,pageSize);
        List<Window> windowList = windowService.getAll();
        //PageInfo<Window> list =new PageInfo<>(windowList);
        model.addAttribute("lists", windowList);
        return "adv";
    }
    @RequestMapping("/getWindows")
    public String listWindow2(Model model){
        List<Window> windowList = windowService.getAll();
        model.addAttribute("windowList", windowList);
        return "add-employee";
    }

    @RequestMapping("/deleteById")
    public String deleteWindow(@RequestParam("id") Integer id){
        windowService.deleteById(id);
        return "redirect:/window/getWindow";
    }
    @RequestMapping("/updateById")
    public String updateWindow(@RequestParam("id") Integer id, Model model){
        Window window = windowService.getWindowById(id);
        model.addAttribute("wind",window);
        return "update-window";
    }
    @RequestMapping("/doupdate")
    public String doUpdate(@RequestParam("wid") Integer wid, @RequestParam("openTime") String openTime, @RequestParam("closeTime") String closeTime, @RequestParam("maxCount") int maxCount){
        Window window = new Window();
        window.setMaxCount(maxCount);
        window.setOpenTime(openTime);
        window.setCloseTime(closeTime);
        window.setId(wid);
        windowService.updateWindow(window);
        return "redirect:/window/getWindow";
    }
}
