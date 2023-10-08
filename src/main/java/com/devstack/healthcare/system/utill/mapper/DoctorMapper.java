package com.devstack.healthcare.system.utill.mapper;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.Response.ResponseDoctorDto;
import com.devstack.healthcare.system.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    ResponseDoctorDto toResponseDoctorDto(Doctor doctor);
    Doctor toDoctor(RequestDoctorDto dto);
  List<ResponseDoctorDto> toResponseDoctorDtoList(List<Doctor> list);

}
