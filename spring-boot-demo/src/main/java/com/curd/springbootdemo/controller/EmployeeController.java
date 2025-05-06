package com.curd.springbootdemo.controller;

import com.curd.springbootdemo.entities.Employee;
import com.curd.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/sampleMsg")
    public ResponseEntity<String> testSample() {
        return new ResponseEntity<>("SpringBootSampleApplication", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Long> addEmp(@RequestBody Employee e) {
        Long empId = service.addEmployee(e);
        return new ResponseEntity<>(empId, HttpStatus.CREATED);
    }

    //PathVariable for mandatory fileds in URI
    @GetMapping("/{id}")
    public Employee getEmpDetails(@PathVariable Long id){
       return service.getEmployee(id);
    }
}
