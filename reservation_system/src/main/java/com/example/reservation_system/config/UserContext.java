package com.example.reservation_system.config;

import com.example.reservation_system.daomain.Student;

public class UserContext {

    //ThreadLocal 保证线程安全
    private static ThreadLocal<Student> studentHolder = new ThreadLocal<Student>();

    public static void setUser(Student user) {
        studentHolder.set(user);
    }

    public static Student getUser() {
        return studentHolder.get();
    }

}
