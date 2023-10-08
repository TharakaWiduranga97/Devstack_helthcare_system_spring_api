package com.devstack.healthcare.system.dto.Response.paginated;

import com.devstack.healthcare.system.dto.Response.ResponseDoctorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedDoctorResponseDto {
  private long count;
  private List<ResponseDoctorDto> dataList;


}
