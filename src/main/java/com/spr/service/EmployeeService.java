package com.spr.service;

import com.spr.exception.EmployeeNotFound;
import com.spr.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee create(Employee employee);
    public Employee delete(int id) throws EmployeeNotFound;
    public List<Employee> findAll();
    public Employee update(Employee employee) throws EmployeeNotFound;
    public Employee findById(int id) throws EmployeeNotFound;
    public List<Employee> findByName(String name) throws EmployeeNotFound;
    public List<Employee> searchByName(String name) throws EmployeeNotFound;

}
