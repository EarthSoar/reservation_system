package com.example.reservation_system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ConfigurationProperties(prefix = "project")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权Url  配置授权域即可
     */
    public String wechatMpAuthorize;


    /**
     * 本项目的地址
     */
    public String project;
}
