package edu.sjsu.cmpe275.cartpool.cartpool.services;

import com.sun.javaws.IconUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.SQLOutput;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService{

    private final JavaMailSender mailSender;

    @Override
    public void sendHtmlMail(String to, String subject, String content){

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);

            //messageHelper.setFrom(from);

            messageHelper.setTo(to);

            message.setSubject(subject);

            messageHelper.setText(content, true);

            //mailSender.send(message);

            System.out.println(content);

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
