package com.example.mailsender_java_live_project.controller;


import com.example.mailsender_java_live_project.dto.CustomerContactMailDto;
import com.example.mailsender_java_live_project.model.User;
import com.example.mailsender_java_live_project.service.CustomerContactMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class MailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);


    @Autowired
    CustomerContactMailService customerContactMailService;

    @PostMapping ("/send")
    public String sendContactEmail(@RequestBody CustomerContactMailDto customerContactMailDto) {
        try {
            customerContactMailService.sendNotification(customerContactMailDto);
            return "Email sent successfully!";
        } catch (MailException e) {
            LOGGER.error("Error sending email: {}", e.getMessage());
            return "Error sending email: " + e.getMessage();
        }
    }
}




