package com.company.MobiConnect2.controller;

import com.company.MobiConnect2.entity.Employee;
import com.company.MobiConnect2.entity.Project;
import com.company.MobiConnect2.repository.EmployeeRepository;
import com.company.MobiConnect2.repository.ProjectRepository;
import com.company.MobiConnect2.service.EmployeeProjectService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/projects")
public class EmployeeProjectController {
    private EmployeeRepository employeeRepository;

    private final EmployeeProjectService employeeService;

    public EmployeeProjectController(EmployeeProjectService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}