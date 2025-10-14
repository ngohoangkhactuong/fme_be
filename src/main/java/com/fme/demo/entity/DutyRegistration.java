package com.fme.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "duty_registrations")
@Data
public class DutyRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(name = "student_id", nullable = false, unique = true)
  private String studentId;

  @Column(nullable = false)
  private String email;

  @Column(name = "duty_date", nullable = false)
  private LocalDate dutyDate;

  @Column(name = "duty_shift", nullable = false)
  private String dutyShift;

  @Column(name = "registration_timestamp", nullable = false)
  private LocalDateTime registrationTimestamp;

  @PrePersist
  protected void onCreate() {
    registrationTimestamp = LocalDateTime.now();
  }
}
