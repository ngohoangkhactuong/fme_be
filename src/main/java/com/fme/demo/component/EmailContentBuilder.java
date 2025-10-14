package com.fme.demo.component;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailContentBuilder {

  @Autowired private final MessageSource messageSource;

  public String getRegistrationConfirmationSubject(Locale locale) {
    return messageSource.getMessage("email.registration.subject", null, locale);
  }

  public String buildRegistrationConfirmationBody(DutyRegistrationRequest details, Locale locale) {
    Object[] params =
        new Object[] {
          details.getName(),
          details.getStudentId(),
          details.getDutyDate().toString(),
          details.getDutyShift()
        };
    return messageSource.getMessage("email.registration.body", params, locale);
  }
}
