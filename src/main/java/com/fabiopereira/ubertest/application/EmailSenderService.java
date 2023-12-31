package com.fabiopereira.ubertest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiopereira.ubertest.adapters.EmailSenderGateway;
import com.fabiopereira.ubertest.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
