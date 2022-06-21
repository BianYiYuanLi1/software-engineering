package com.book.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public boolean sendVerificationCode(String address,int verificationCode){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("智慧图书馆注册");
        //读取信息
        StringBuilder formatMessage = new StringBuilder();

        formatMessage.append("你本次的注册验证码是："+verificationCode);
        System.out.println(">>>>>>>>>>>>>>"+formatMessage+"<<<<<<<<<<<<<<<<<<");
        //设置邮件消息
        message.setText(formatMessage.toString());
        message.setFrom("1584868178@qq.com");
        message.setTo(address);
        message.setSentDate(new Date());
        try {
            javaMailSender.send(message);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
