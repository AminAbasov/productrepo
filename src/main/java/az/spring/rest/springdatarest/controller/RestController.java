package az.spring.rest.springdatarest.controller;

import az.spring.rest.springdatarest.dto.EmployeeDto;
import az.spring.rest.springdatarest.response.EmployeeResponse;
import az.spring.rest.springdatarest.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final EmployeeService employeeService;

    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public EmployeeResponse getAll(){
        return employeeService.getALl();
    }
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable("id") long id){
        return employeeService.getById(id);
    }

    @PostMapping("/create")
    public void insert(@RequestBody @Valid EmployeeDto employeeDto){
        employeeService.insert(employeeDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EmployeeDto employeeDto,long id){
        employeeService.update(employeeDto,id);
    }

    @GetMapping("/search")
    public EmployeeResponse findByNameAndSurname(@RequestParam("name") String name,
                                                 @RequestParam("surname") String surname){
        return employeeService.findByNameAndSurname(name,surname);
    }

}
