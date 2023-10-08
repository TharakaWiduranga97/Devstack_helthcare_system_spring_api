package com.devstack.healthcare.system.service.impl;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import com.devstack.healthcare.system.dto.Response.ResponseDoctorDto;
import com.devstack.healthcare.system.dto.Response.paginated.PaginatedDoctorResponseDto;
import com.devstack.healthcare.system.entity.Doctor;
import com.devstack.healthcare.system.exceptions.EntryNotFoundException;
import com.devstack.healthcare.system.repo.DoctorRepo;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    @Autowired

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {
        UUID uuid = UUID.randomUUID();
        long id = uuid.getMostSignificantBits() ;

        Doctor doctor = new Doctor(

                id,
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getSalary()
        );
        doctorRepo.save(doctor);

    }

    @Override
    public void updateDoctor(Long id,RequestDoctorDto dto) {

            Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
            if (selectedDoctor.isEmpty()){
                throw new EntryNotFoundException("Doctor Not Found");
            }
            Doctor doctorSel=selectedDoctor.get();
            doctorSel.setName(dto.getName());
            doctorSel.setAddress(dto.getAddress());
            doctorSel.setContact(dto.getContact());
            doctorSel.setSalary(dto.getSalary());
            doctorRepo.save(doctorSel);
    }

    @Override
    public List<ResponseDoctorDto> findDoctorByName(String name) {
        List<Doctor> doctorByName = doctorRepo.findDoctorByName(name);
        return null;
    }

    @Override
    public void deleteDoctor(Long id) {

        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor Not Found");
        }
        doctorRepo.deleteById(selectedDoctor.get().getId());

    }

    @Override
    public ResponseDoctorDto getDoctor(Long id) {

        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor Not Found");
        }
        Doctor doctorSel=selectedDoctor.get();
        return new ResponseDoctorDto(
                doctorSel.getId(),
                doctorSel.getName(),
                doctorSel.getAddress(),
                doctorSel.getContact(),
                doctorSel.getSalary()
        );

    }

    @Override
    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size) {
        List<Doctor> doctors = doctorRepo.searchDoctors(searchText, PageRequest.of(page, size));
        Long doctorCount = doctorRepo.countDoctors(searchText);
        List<ResponseDoctorDto> dtos = new ArrayList<>();
        doctors.forEach(doc->{
            dtos.add(
                    new ResponseDoctorDto(
                            doc.getId(),
                            doc.getName(),
                            doc.getAddress(),
                            doc.getContact(),
                            doc.getSalary()
                    )

            );
        });
        return new PaginatedDoctorResponseDto(
                doctorCount,
                dtos
        );
    }
}
