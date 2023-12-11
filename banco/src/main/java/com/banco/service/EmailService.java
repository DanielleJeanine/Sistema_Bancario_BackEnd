package com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail (String para, String assunto, String conteudo){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("danielle.jeanine92@gmail.com"); //usar mesmo e-amil que está configurado no application.properties
        message.setTo(para);
        message.setSubject(assunto);
        message.setText(conteudo);

        mailSender.send(message);
    }
    
}
