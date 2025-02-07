package az.spring.rest.springdatarest.service;

import az.spring.rest.springdatarest.dto.EmployeeDto;
import az.spring.rest.springdatarest.model.Employee;
import az.spring.rest.springdatarest.repository.EmployeeRepository;
import az.spring.rest.springdatarest.response.EmployeeResponse;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse getALl(){
        List<EmployeeDto>employeeDtos=employeeRepository.findAll().
                stream().map(employee -> convertToDto(employee))
                .collect(Collectors.toList());
        return EmployeeResponse.builder()
                .employees(employeeDtos)
                .build();
    }

    public EmployeeDto getById(Long id){
         return employeeRepository.findById(id).map(employee -> convertToDto(employee)).
                 orElseThrow(()->new RuntimeException("bele idli element tapilmadi"));
    }

    public void insert(EmployeeDto employeeDto){
        Employee employee=convertToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    public void update(EmployeeDto employeeDto,long id){
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new RuntimeException("update elemek ucun id tapilmadi"));

        employee.setName(employeeDto.getName());
        employee.setSurname(employee.getSurname());
        employee.setAge(employeeDto.getAge());

        employeeRepository.save(employee);
    }

    public void updateSome(EmployeeDto employeeDto,long id){
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new RuntimeException("update elemek ucun id tapilmadi"));

        if(employee.getName()!=null)
        employee.setName(employeeDto.getName());

        if(employee.getSurname()!=null)
        employee.setSurname(employee.getSurname());

        if (employee.getAge()>0)
        employee.setAge(employeeDto.getAge());

        employeeRepository.save(employee);
    }

    public EmployeeResponse findByNameAndSurname(String name,String surname){
       List<EmployeeDto>employeeDtos= employeeRepository.findByNameAndSurname(name,surname)
                .stream().map(this::convertToDto).collect(Collectors.toList());
       return EmployeeResponse.builder().employees(employeeDtos).build();
    }

    private EmployeeDto convertToDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .age(employee.getAge())
                .name(employee.getName())
                .surname(employee.getSurname())
                .build();
    }
    private Employee convertToEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return employee;
    }



}
