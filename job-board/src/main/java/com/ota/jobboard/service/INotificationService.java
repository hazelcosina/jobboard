package com.ota.jobboard.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface INotificationService {
    void sendEmail(String email, String subject, String content) throws UnsupportedEncodingException, MessagingException;
}
