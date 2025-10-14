package com.fme.demo.repository;

import com.fme.demo.entity.DutyRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRegistrationRepository extends JpaRepository<DutyRegistration, Long> {
}
