package com.example.MySpringProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MySpringProject.services.EmployeeService;

import org.springframework.ui.Model;

import java.util.List;
import com.example.MySpringProject.Entity.*;

@Controller
public class HomeController {
    
    @Autowired
    private EmployeeService service;

    /**
     * CRUD - Read Operation
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
     * CURD - Create Operation
     * Process : 
     * Step 1: Add Employee Button Click.
     * Step 2: GET /form, Inject Model, Redirect to Form Filling with empty object.
     * Step 3: POST /add, Form send's Detail to Controller to be saved.
     * Step 4: Redirect to Home Page.
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
     * CRUD - Delete Operation
     * Process: 
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
     * CRUD - Update Operation
     * Process : 
     * Step 1: Click Edit button
     * Step 2: GET /edit, Inject Model, get the Object via id
     * Step 3: Redirect to "update form" with data.
     * Step 4: POST /update
     * @param emp
     * @param id
     * @return
    */

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        Employee emp = service.find(id);
        model.addAttribute("employee", emp);
        return "edit";
    }
    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute Employee emp, @PathVariable Long id){
        service.update(id,emp);
        return "redirect:/";
    }

}
