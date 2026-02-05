package com.example.MySpringProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MySpringProject.repository.EmployeeRepo;

import java.util.List;
import com.example.MySpringProject.Entity.*;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> findAll(){
        return repo.findAll();
    }

    public void save(Employee emp){
        repo.save(emp);
        // return true;
    }

    public Employee find(Long id){
        return repo.findById(id).orElse(null);
    }

    public void update(Long id, Employee updatedEmployee){
        Employee emp = repo.findById(id).orElse(new Employee());
        emp.setName(updatedEmployee.getName());
        emp.setDepartment(updatedEmployee.getDepartment());
        emp.setSalary(updatedEmployee.getSalary()); 
        return;
    }

    public void delete(Long id){
        Employee emp = repo.findById(id).orElse(null);
        if(emp!=null){
            repo.delete(emp);
        }
        return;
    }

}
