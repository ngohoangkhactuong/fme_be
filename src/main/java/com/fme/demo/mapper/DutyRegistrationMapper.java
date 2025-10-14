package com.fme.demo.mapper;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import com.fme.demo.dto.dutyRegistration.DutyRegistrationResponse;
import com.fme.demo.entity.DutyRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DutyRegistrationMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "registrationTimestamp", ignore = true)
  DutyRegistration toEntity(DutyRegistrationRequest request);

  DutyRegistrationResponse toDto(DutyRegistration dutyRegistration);
}
