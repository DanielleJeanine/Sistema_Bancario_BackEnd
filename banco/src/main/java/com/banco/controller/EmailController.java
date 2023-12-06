package com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.banco.service.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin(value = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String content) {
        emailService.sendSimpleEmail(to, subject, content);

        return "E-mail enviado com sucesso";
    }
}
