package com.example.crud.service;


import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAll() {

     return   employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }
}
