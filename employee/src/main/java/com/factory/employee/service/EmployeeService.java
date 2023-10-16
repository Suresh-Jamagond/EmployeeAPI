package com.factory.employee.service;

import com.factory.employee.Repository.EmployeeRepository;
import com.factory.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee (Employee employee)
    {
        employeeRepository.save(employee);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Employee>> getEmployees()
    {
        List<Employee> employeeList;
        employeeList = employeeRepository.findAll();
        return  new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeeByID(Long id) {
        Optional<Employee> employee=employeeRepository.findById(id);

        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public String updateEmployeeByID(Long id , Employee employee) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
          Employee existEmp= emp.get();
          existEmp.setEmployeeCity(employee.getEmployeeCity());
          existEmp.setEmployeeAge(employee.getEmployeeAge());
          existEmp.setEmployeeName(employee.getEmployeeName());
          employeeRepository.save(existEmp);
          return ("Employee Details of " + id + " are updated");
        }
        return ("Employee Details of " + id + " are not present");
    }

    public String deleteEmployeeByID(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()) {
            employeeRepository.deleteById(id);
            return ("Employee of " + id + " is Deleted");
        }
        else {
            return ("Employee Details of " + id + " are not present");
        }
    }

    public  List<Employee> getEmployeesByCity(String city) {
        List<Employee> emp = employeeRepository.findByEmployeeCity(city);
        return  emp;
    }

    public List<Employee> getEmployeesByAge(Integer age) {

        List<Employee> emp = employeeRepository.findAll();
        return emp.stream()
                .filter(i ->i.getEmployeeAge()<= age)
                .collect(Collectors.toList());
    }
}
