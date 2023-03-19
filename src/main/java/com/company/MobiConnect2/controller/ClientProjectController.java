package com.company.MobiConnect2.controller;

import com.company.MobiConnect2.entity.Client;
import com.company.MobiConnect2.entity.Employee;
import com.company.MobiConnect2.entity.Project;
import com.company.MobiConnect2.repository.ClientRepository;
import com.company.MobiConnect2.repository.EmployeeRepository;
import com.company.MobiConnect2.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/projects/clients")
public class ClientProjectController {

    private ClientRepository clientRepository;
    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;


    public ClientProjectController(ClientRepository clientRepository,
                                   ProjectRepository projectRepository,
                                   EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public Project saveProjectWithClient(@RequestBody Project project){
        Client client = project.getClient();// Get the client from the project
        Set<Employee> employees = project.getEmployees();
        clientRepository.save(client); // Save the client to the database
        employeeRepository.saveAll(employees);
        project.setClient(client); // Set the client to the project
        project.setEmployees(employees);
        return projectRepository.save(project); // Save the project to the database
    }
    @GetMapping
    public List<Project> findAllStudents(){
        return projectRepository.findAll();
    }

    @GetMapping("/{projectId}")
    public Project findProject(@PathVariable Long projectId){
        return projectRepository.findById(projectId).orElse(null);
    }
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project newProject) {
        Project project = projectRepository.findById(id).orElse(null); // Find the existing project
        if (project != null) {
            Client client = newProject.getClient(); // Get the client from the request body
            Set<Employee> employees = newProject.getEmployees(); // Get the employees from the request body
            clientRepository.save(client); // Save the client to the database
            employeeRepository.saveAll(employees); // Save the employees to the database
            project.setName(newProject.getName()); // Update the project's name
            // Update the project's description
            project.setClient(client); // Set the project's client to the updated client
            project.setEmployees(employees); // Set the project's employees to the updated employees
            return projectRepository.save(project); // Save the updated project to the database
        } else {
            return null; // Return null if no project with the specified ID is found
        }
    }

}