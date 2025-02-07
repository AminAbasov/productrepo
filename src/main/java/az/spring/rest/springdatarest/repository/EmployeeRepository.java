package az.spring.rest.springdatarest.repository;

import az.spring.rest.springdatarest.model.Employee;
import az.spring.rest.springdatarest.response.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameAndSurname(String name, String surname);
}
