package com.fabiopereira.ubertest.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
