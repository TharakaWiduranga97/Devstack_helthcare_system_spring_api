package com.devstack.healthcare.system.service;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.Response.ResponseDoctorDto;
import com.devstack.healthcare.system.dto.Response.paginated.PaginatedDoctorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface DoctorService {

    public void createDoctor(RequestDoctorDto dto);
    public void updateDoctor(Long id,RequestDoctorDto dto);

    public List<ResponseDoctorDto> findDoctorByName(String name);

    public void deleteDoctor(Long id);
    public ResponseDoctorDto getDoctor(Long id);
    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size);




}
