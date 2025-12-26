package com.fme.demo.mapper;

import com.fme.demo.dto.dutyRegistration.DutyRegistrationRequest;
import com.fme.demo.dto.dutyRegistration.DutyRegistrationResponse;
import com.fme.demo.entity.DutyRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DutyRegistrationMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "registrationTimestamp", ignore = true)
  DutyRegistration toEntity(DutyRegistrationRequest request);

  List<DutyRegistration> toEntityList(List<DutyRegistrationRequest> requests);

  DutyRegistrationResponse toDto(DutyRegistration dutyRegistration);

  List<DutyRegistrationResponse> toDtoList(List<DutyRegistration> dutyRegistrations);
}
