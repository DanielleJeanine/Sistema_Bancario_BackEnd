package com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail (String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jose108241santos@gmail.com"); //usar mesmo e-amil que está configurado no application.properties
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }
    
}
