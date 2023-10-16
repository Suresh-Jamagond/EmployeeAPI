package com.factory.employee.controller;

import com.factory.employee.Repository.EmployeeRepository;
import com.factory.employee.model.Employee;
import com.factory.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public  ResponseEntity<String> CreateEmployee(@RequestBody  Employee employee)
    {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees ()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long id)
    {
        return employeeService.getEmployeeByID(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployeeByID(@PathVariable Long id, @RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.updateEmployeeByID(id,employee), HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable Long id)
    {
            return new ResponseEntity<>(employeeService.deleteEmployeeByID(id), HttpStatus.OK);
    }

    @GetMapping("/employee/{city}")
    public ResponseEntity<List<Employee>> getEmployeesByCity(@PathVariable String city)
    {
      return new ResponseEntity<>(employeeService.getEmployeesByCity(city),HttpStatus.OK);

    }
    @GetMapping("/getEmployees/{age}")
    public ResponseEntity<List<Employee>> getEmployeesByAge(@PathVariable Integer age)
    {
        return new ResponseEntity<>(employeeService.getEmployeesByAge(age),HttpStatus.OK);

    }

}
