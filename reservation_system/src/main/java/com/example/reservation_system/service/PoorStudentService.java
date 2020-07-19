package com.example.reservation_system.service;

import com.example.reservation_system.dao.PoorStudentDAO;
import com.example.reservation_system.daomain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Service
public class PoorStudentService {
    @Autowired
    private PoorStudentDAO poorStudentDAO;

    public Student getStudentByCard(String cardId) {
        return poorStudentDAO.getStudentByCard(cardId);
    }
}
