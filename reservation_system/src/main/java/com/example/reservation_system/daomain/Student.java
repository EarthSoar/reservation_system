package com.example.reservation_system.daomain;

import lombok.Data;

/**
 * @author Willing
 * @date 2020/4/6
 */
@Data
public class Student {
    private String id;//手机号
    private String openId;
    private String name;
    private int sex;
    private String cardId;//身份证号
}
