package com.fme.demo.controller;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import com.fme.demo.service.DutyRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registrations")
@CrossOrigin(origins = "http://localhost:3000")
public class DutyRegistrationController {

  @Autowired
  private DutyRegistrationService service;

  @PostMapping
  public ResponseEntity<?> createDutyRegistration(@RequestBody DutyRegistrationRequest request) {
    return new ResponseEntity<>(service.registerDuty(request), HttpStatus.CREATED);
  }
}
