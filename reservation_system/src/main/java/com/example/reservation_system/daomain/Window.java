package com.example.reservation_system.daomain;

import lombok.Data;

import java.util.Date;

/**
 * @author Willing
 * @date 2020/4/27
 */
@Data
public class Window {
    private Integer id;//窗口号码
    private Integer waitCount;//等待人数
    private Integer currentSid;//正在受理的序号
    private Integer maxCount;
    private String openTime;//开始工作时间
    private String closeTime;//结束工作时间
}
