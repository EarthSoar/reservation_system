package com.example.reservation_system.service;

import com.example.reservation_system.dao.StudentDAO;
import com.example.reservation_system.daomain.Student;
import com.example.reservation_system.exception.GlobalException;
import com.example.reservation_system.result.CodeMsg;
import com.example.reservation_system.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Struct;
import java.util.List;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Service
public class StudentService {
    public static final String Student_NAME_TOKEN = "student_token";

    @Resource
    private StudentDAO studentDAO;

    public boolean authentication(Student student, HttpServletRequest request){
        if(student == null){
            throw new RuntimeException("参数错误,认证失败");
        }

        String cardId = student.getCardId();//身份证

        Student student1 = studentDAO.getByCardId(cardId);
        if(student1 == null){
            return false;
        }
        request.getSession().setAttribute("STUDNET_IN_SESSION", student);

        return true;
    }

    public Student getStudentByPhone(String phoneNum){
        return studentDAO.getById(phoneNum);
    }

    public List<Student> listAllStudent(){
        return studentDAO.listAll();
    }

    public void addStudent(Student student){
        studentDAO.save(student);
    }
}
