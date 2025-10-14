package com.fme.demo.dto.dutyRegistration;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DutyRegistrationRequest {
  private String name;
  private String studentId;
  private String email;
  private LocalDate dutyDate;
  private String dutyShift;
}
