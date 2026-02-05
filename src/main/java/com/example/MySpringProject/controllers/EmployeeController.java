package com.example.MySpringProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import com.example.MySpringProject.Entity.Employee;
import com.example.MySpringProject.services.EmployeeService;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService service;
 
    // @GetMapping("/")
    // public List<Employee> getAllEmployees(Model model){
    //     return service.findAll();
    // }
    // @PostMapping("/add")
    // public boolean addEmployee(@RequestBody Employee employee){
    //     service.save(employee);
    //     return true;
    // }
    // @GetMapping("/employee/{id}")
    // public Employee getEmployee(@PathVariable Long id){
    //     return service.find(id);
    // }

    // @GetMapping("/index")
    // public String viewHomePage(Model model){
    //     return "index";
    // }

}
