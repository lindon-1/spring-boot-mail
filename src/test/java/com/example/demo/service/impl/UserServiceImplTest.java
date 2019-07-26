package com.example.demo.service.impl;

import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void findByNameTest() {
//        SysUser admin = userService.findByUserName("admin");
//        System.out.println(admin == null);

        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println(of);

        LocalDateTime t = LocalDateTime.of(of.getYear(), of.getMonth(), of.getDayOfMonth(), 23, 59, 59);
        LocalDateTime with = t.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with);
    }
}