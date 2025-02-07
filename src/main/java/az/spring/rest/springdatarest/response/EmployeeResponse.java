package az.spring.rest.springdatarest.response;

import az.spring.rest.springdatarest.dto.EmployeeDto;
import az.spring.rest.springdatarest.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {
    List<EmployeeDto>employees;
}
