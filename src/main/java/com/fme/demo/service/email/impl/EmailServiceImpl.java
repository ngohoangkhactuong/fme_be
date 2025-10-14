package com.fme.demo.service.email.impl;

import com.fme.demo.component.EmailContentBuilder;
import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import com.fme.demo.service.email.EmailService;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

  @Autowired private JavaMailSender mailSender;
  @Autowired private EmailContentBuilder contentBuilder;

  @Value("${spring.mail.username}")
  private String fromEmailAddress;

  @Override
  @Async
  public void sendRegistrationConfirmationEmail(
      DutyRegistrationRequest registrationDetails, Locale locale) {
    String recipientEmail = registrationDetails.getEmail();
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(fromEmailAddress);
      message.setTo(recipientEmail);

      message.setSubject(contentBuilder.getRegistrationConfirmationSubject(locale));
      String emailBody =
          contentBuilder.buildRegistrationConfirmationBody(registrationDetails, locale);
      message.setText(emailBody);

      mailSender.send(message);
      log.info("Email sent successfully: {}", recipientEmail);

    } catch (MailException e) {
      log.error("Failed when send email for user {}: {}", recipientEmail, e.getMessage(), e);
    }
  }
}
