package com.devstack.healthcare.system.api;

import com.devstack.healthcare.system.dto.Request.RequestDoctorDto;
import com.devstack.healthcare.system.service.DoctorService;
import com.devstack.healthcare.system.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> CreateDoctor(@RequestBody RequestDoctorDto doctorDto){

     doctorService.createDoctor(doctorDto);
     return new ResponseEntity<>(new StandardResponse
             (201,"Doctor was saved",doctorDto.toString()), HttpStatus.CREATED);


    }
    @GetMapping(path="/{id}")
    public ResponseEntity<StandardResponse> FindDoctor(@PathVariable Long id){
        return new ResponseEntity<>(
                new StandardResponse
                (200,"Doctor data",doctorService.getDoctor(id)), HttpStatus.OK);
    }
   @PutMapping(params="id")
    public ResponseEntity<StandardResponse> UpdateDoctor(
            @RequestParam Long id,
            @RequestBody RequestDoctorDto doctorDto){

       doctorService.updateDoctor(id,doctorDto);
       return new ResponseEntity<>(new StandardResponse
               (201,"Doctor updated",doctorDto.toString()), HttpStatus.CREATED);


    }
   @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> DeleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(new StandardResponse
                (204,"Doctor deleted",id), HttpStatus.NO_CONTENT);
    }
    @GetMapping(path="/list" , params={"searchText","page","size"})
    public ResponseEntity<StandardResponse> FindAllDoctor(
            @RequestParam String searchText,
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        return new ResponseEntity<>(new StandardResponse
                (200,"data list",doctorService.getAllDoctors(
                        searchText,page,size
                )), HttpStatus.OK);
    }

}
