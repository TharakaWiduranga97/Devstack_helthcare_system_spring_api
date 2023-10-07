package com.devstack.healthcare.system.api;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import com.devstack.healthcare.system.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public String CreateDoctor(@RequestBody RequestDoctorDto doctorDto){

     doctorService.createDoctor(doctorDto);
     return doctorDto.toString();

    }
    @GetMapping(path="/{id}")
    public String FindDoctor(@PathVariable String id){

        return id+"";
    }
   @PutMapping(params="id")
    public String UpdateDoctor(
            @RequestParam String id,
            @RequestBody RequestDoctorDto doctorDto){
        return doctorDto.toString();
    }
   @DeleteMapping("/{id}")
    public String DeleteDoctor(@PathVariable String id){
        return id+"";
    }
    @GetMapping(path="/list" , params={"searchText","page","size"})
    public String FindAllDoctor(
            @RequestParam String searchText,
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        return "All Doctors Found";
    }

}
