package com.example.MySpringProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MySpringProject.services.EmployeeService;

import org.springframework.ui.Model;

import java.util.List;
import com.example.MySpringProject.Entity.*;

@Controller
public class HomeController {
    
    @Autowired
    private EmployeeService service;

    /**
     * CRUD
     * R = Reading Data form database.
     * @param model
     * @return
     */


    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Employee> list = service.findAll();
        System.out.println("Employees : "+ list);
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * CURD
     * C = Creating new Employee.
     * Adding Employee Process : 
     * Step 1 : Add Employee Button Click.
     * Step 2 : Redirect to Form Filling.
     * Step 3 : Form send's Detail to Controller to be saved.
     * Step 4 : Redirect to Home Page.
     * @param emp
     */

    @GetMapping("/form")
    public String showAddForm(Model model){
        model.addAttribute("employee", new Employee());
        return "/form";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee emp){
        service.save(emp);
        return "redirect:/";
    }

    /**
     * CRUD
     * D = Deleting Employee from database.
     * Deleting Employee Process : 
     * Step 1: Click Delete Button
     * Step 2: Send id to Controller via Path Variable.
     * Step 3: Delete Employee
     * Step 4: Redirect to "/"
     * @param emp
     * @param id
     * @return
     */

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.delete(id);
        return "redirect:/";
    }

/**
 * CRUD 
 * U = Updating Employee Details.
 * @param emp
 * @param id
 * @return
*/



    @PutMapping("/edit/{id}")
    public String updateEmployee(@RequestBody Employee emp, @PathVariable Long id){
        return "update";
    }



}
