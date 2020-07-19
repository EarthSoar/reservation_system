package com.example.reservation_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Willing
 * @date 2020/4/7
 */
@Service
public class WechatService {
    @Autowired
    private StudentService studentService;

    public void save(String openId) {
        //studentService.setOpenId(openId);
    }
}
