package com.example.reservation_system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 公众号appId
     */
    private String mpAppId;
    /**
     * 公众号appSecret
     */
    private String mpAppSecret;

}
