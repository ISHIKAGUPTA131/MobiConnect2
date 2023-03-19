package com.company.MobiConnect2.repository;

import com.company.MobiConnect2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
