package com.example.reservation_system.util;

import java.util.UUID;

/**
 * @author Willing
 * @date 2020/4/7
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
