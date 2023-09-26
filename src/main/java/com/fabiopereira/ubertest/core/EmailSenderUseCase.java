package com.fabiopereira.ubertest.core;

public interface EmailSenderUseCase {
    
    void sendEmail(String to, String subject, String body);
}
