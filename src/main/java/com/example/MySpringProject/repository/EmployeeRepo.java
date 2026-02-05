package com.example.MySpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MySpringProject.Entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    
}
