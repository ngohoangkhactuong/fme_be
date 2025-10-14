package com.fme.demo.service.email;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import java.util.Locale;

public interface EmailService {
  void sendRegistrationConfirmationEmail(DutyRegistrationRequest registrationDetails, Locale locale);
}
