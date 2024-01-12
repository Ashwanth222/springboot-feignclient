package com.springboot.springbootfeignclient.controller;

import com.springboot.springbootfeignclient.model.Employee;
import com.springboot.springbootfeignclient.model.EmployeeResponse;
import com.springboot.springbootfeignclient.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addNewEmployee")
    public String addNewUser(@RequestBody Employee employee) {
        return employeeService.addUser(employee);
    }


    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

}

