package com.devstack.healthcare.system.api;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @PostMapping
    public String CreateDoctor(@RequestBody RequestDoctorDto doctorDto){
       return doctorDto.toString();


    }
    @GetMapping
    public String FindDoctor() {
        return "Doctor Found";
    }
   @PutMapping
    public String UpdateDoctor() {
        return "Doctor Updated";
    }
   @DeleteMapping
    public String DeleteDoctor() {
        return "Doctor Deleted";
    }
    @GetMapping(path="/all")
    public String FindAllDoctor() {
        return "All Doctors Found";
    }

}
