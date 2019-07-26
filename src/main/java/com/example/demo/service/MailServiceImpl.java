package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @author: lindl
 * @Date: 2019/7/4 9:47
 */
@Component
public class MailServiceImpl {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    //private TemplateEngine templateEngine = new TemplateEngine();

    @Value("${mail.fromMail.addr}")
    private String from;
/**
* @Description: 
* @param: * @param null 
* @return:  
* @author: lindl
* @Date: 2019/7/8 18:07
*/ 
    public void sendMailMess(String to, String subject, String comment) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(comment);
        simpleMailMessage.setSubject(subject);

        try {
            mailSender.send(simpleMailMessage);
            logger.info("mail was sent");
        } catch (MailException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendFileMailMess(String to, String subject, String comment,String filePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setText(comment);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(0, filePath.lastIndexOf(File.separator));
            mimeMessageHelper.addAttachment(fileName,fileSystemResource);

            mailSender.send(mimeMessage);
            logger.info("mail was sent...");

        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendTemplateMess(String to, String subject, String comment) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(comment,true);
            mimeMessageHelper.setFrom(from);

            mailSender.send(mimeMessage);
            logger.info("mail was sent..");
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
    }
}
