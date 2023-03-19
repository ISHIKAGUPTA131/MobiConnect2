package com.company.MobiConnect2.service;

import com.company.MobiConnect2.entity.Employee;
import com.company.MobiConnect2.entity.Project;
import com.company.MobiConnect2.repository.EmployeeRepository;
import com.company.MobiConnect2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectService {

    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public EmployeeProjectService(EmployeeRepository employeeRepository,
                                  ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (existingEmployee == null) {
            return null;
        }
        // Update the existing employee object with the new data
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setContact(employee.getContact());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setWorkLocation(employee.getWorkLocation());
        existingEmployee.setDateOfJoin(employee.getDateOfJoin());
        existingEmployee.setDateOfExit(employee.getDateOfExit());
        existingEmployee.setManager(employee.getManager());
        existingEmployee.setTotalLeaves(employee.getTotalLeaves());
        existingEmployee.setLeaveBalance(employee.getLeaveBalance());
        existingEmployee.setProjects(employee.getProjects());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long projectId, Project project) {
        Project existingProject = projectRepository.findById(projectId).orElse(null);
        if (existingProject == null) {
            return null;
        }
        // Update the existing project object with the new data
        existingProject.setName(project.getName());
        existingProject.setOwnerClient(project.getOwnerClient());
        existingProject.setOwnerConsultant(project.getOwnerConsultant());
        existingProject.setStartDate(project.getStartDate());
        existingProject.setEndDate(project.getEndDate());
        existingProject.setStatus(project.getStatus());
        existingProject.setEmployees(project.getEmployees());
        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
