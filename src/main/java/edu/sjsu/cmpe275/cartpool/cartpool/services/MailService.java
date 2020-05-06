package edu.sjsu.cmpe275.cartpool.cartpool.services;

public interface MailService {
    void sendHtmlMail(String to, String subject, String content);
}
