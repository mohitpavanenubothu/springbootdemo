package com.curd.springbootdemo.service;

import com.curd.springbootdemo.entities.Employee;

public interface EmployeeService {
    Long addEmployee(Employee employee);

    Employee getEmployee(Long id);
}
