package com.example.reservation_system.controller;

import com.example.reservation_system.daomain.Evaluate;
import com.example.reservation_system.daomain.Student;
import com.example.reservation_system.service.EvaluateService;
import com.example.reservation_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Resource
    private EvaluateService evaluateService;

    @RequestMapping("/getAllStudent")
    public String getAllStudent(Model model){
        List<Student> students = studentService.listAllStudent();
        model.addAttribute("students", students);
        return "list-student";
    }

    @RequestMapping("/toaddStudent")
    public String toAddStudent(){
        return "add-student";
    }

    @RequestMapping("/doaddStudent")
    public String doaddWindow(Student student){
        studentService.addStudent(student);
        return "redirect:/student/getAllStudent";
    }


    @RequestMapping("/toEvaluate")
    public String toEvaluate(){
        return "mobile/evaluate";
    }

    @RequestMapping("/doEvaluate")
    public String doEvaluate(Evaluate evaluate, Model model){
        if(evaluate == null){
            model.addAttribute("result", "请认真评价，谢谢！");
        }else{
            evaluateService.evaluate(evaluate);
            model.addAttribute("result", "已完成评价，谢谢！");
        }
        return "mobile/evaluate";
    }
}
