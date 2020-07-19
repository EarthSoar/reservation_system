package com.example.reservation_system.daomain;

import lombok.Data;

/**
 * @author Willing
 * @date 2020/4/27
 */
@Data
public class Employee {
    private String id;//工号
    private String name;
    private Integer windowId;//窗口号
    private String phoneNum;
    private String password;
}
