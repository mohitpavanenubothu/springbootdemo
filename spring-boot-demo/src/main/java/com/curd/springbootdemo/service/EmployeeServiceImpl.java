package com.curd.springbootdemo.service;

import com.curd.springbootdemo.entities.Employee;
import com.curd.springbootdemo.exeception.EmployeeNotFoundException;
import com.curd.springbootdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public Long addEmployee(Employee employee) {
        Long empId = repo.save(employee).getEmpId();
        System.out.println("Employee Id is:::" + empId);
        return empId;
    }

    @Override
    public Employee getEmployee(Long id) {
        return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id" + id));
    }
}
