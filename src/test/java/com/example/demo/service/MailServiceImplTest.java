package com.example.demo.service;

import com.example.demo.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailServiceImpl mailService;

    @Resource
    private UserService userService;


    @Test
    public void MailTest() {
        mailService.sendMailMess("13432677363@163.com","1234","today is nice!");
    }

    @Test
    public void FileMailTest() {
        mailService.sendFileMailMess("13432677363@163.com", "haha", "today is furty!","E:\\西墨\\abc.txt");
    }

    @Test
    public void tempTest() {
        mailService.sendTemplateMess("13432677363@163.com", "template html", "<!DOCTYPE html>\n" +
                "<html lang=\"zh\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>邮件模板</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "您好，欢迎注册本系统，您的验证码是: 1d2s\n" +
                "\n" +
                "</br>-- lindl\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    @Test
    public void testDb() {
        SysUser admin = userService.findByUserName("admin");
        System.out.println(admin.toString());
    }
}