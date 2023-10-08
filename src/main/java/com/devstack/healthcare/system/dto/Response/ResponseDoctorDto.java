package com.devstack.healthcare.system.dto.Response;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor



public class ResponseDoctorDto {
    private Long id;
    private String name;
    private String address;

    private String contact;
    private Double salary;
}
