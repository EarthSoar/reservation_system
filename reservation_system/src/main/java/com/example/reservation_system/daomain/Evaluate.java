package com.example.reservation_system.daomain;

import lombok.Data;

@Data
public class Evaluate {
    private String id;//学生的手机号
    private String name;//姓名
    private Integer windowId;//窗口
    private String content;//内容
    private Integer score;//评分
}
