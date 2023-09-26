package com.fabiopereira.ubertest.infra.ses;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.fabiopereira.ubertest.adapters.EmailSenderGateway;
import com.fabiopereira.ubertest.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest sendEmailRequest = new SendEmailRequest()
                .withSource("fabiuhp2@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        send(sendEmailRequest);
    }

    public void send(SendEmailRequest sendEmailRequest) {
        try {
            this.amazonSimpleEmailService.sendEmail(sendEmailRequest);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Failure while sending email.", e);
        }
    }
}