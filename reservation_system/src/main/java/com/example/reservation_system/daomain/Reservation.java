package com.example.reservation_system.daomain;

import lombok.Data;

import java.util.Date;

@Data
public class Reservation {
    private Long id;
    private String sid;
    private Integer wid;
    private Date createTime;
    private Integer state;//预约状态
}
