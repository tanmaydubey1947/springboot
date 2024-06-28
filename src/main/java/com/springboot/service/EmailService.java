package com.springboot.service;

import com.springboot.dto.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendSimpleEmail(EmailRequest request) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(request.getToEmail());
        mailMessage.setSubject(request.getSubject());
        mailMessage.setText(request.getMessageBody());
        javaMailSender.send(mailMessage);

        return "Email Successfully Sent...";
    }

    public String sendEmailWithAttachment(EmailRequest emailRequest) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(sender);
        helper.setTo(emailRequest.getToEmail());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getMessageBody());

        FileSystemResource file = new FileSystemResource(new File(emailRequest.getAttachment()));
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);

        return "Mail Sent Successfully with Attachment" + file.getFilename();
    }

}
