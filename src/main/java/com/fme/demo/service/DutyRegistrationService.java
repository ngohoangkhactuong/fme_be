package com.fme.demo.service;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import com.fme.demo.dto.dutyRegistration.DutyRegistrationResponse;
import com.fme.demo.entity.DutyRegistration;
import com.fme.demo.mapper.DutyRegistrationMapper;
import com.fme.demo.repository.DutyRegistrationRepository;
import com.fme.demo.service.email.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DutyRegistrationService {

  @Autowired private DutyRegistrationRepository repository;

  @Autowired private EmailService emailService;

  @Autowired private DutyRegistrationMapper mapper;

  @Transactional
  public DutyRegistrationResponse registerDuty(DutyRegistrationRequest request) {
    DutyRegistration registration = mapper.toEntity(request);
    DutyRegistration savedRegistration = repository.save(registration);
    emailService.sendRegistrationConfirmationEmail(request, LocaleContextHolder.getLocale());
    return mapper.toDto(savedRegistration);
  }
}
