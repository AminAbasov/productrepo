package az.spring.rest.springdatarest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private int age;
}
