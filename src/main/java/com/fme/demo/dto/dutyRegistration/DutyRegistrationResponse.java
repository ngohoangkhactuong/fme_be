package com.fme.demo.dto.dutyRegistration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DutyRegistrationResponse {
  private Long id;
  private String name;
  private String studentId;
  private String email;
  private LocalDate dutyDate;
  private String dutyShift;
  private LocalDateTime registrationTimestamp;
}
