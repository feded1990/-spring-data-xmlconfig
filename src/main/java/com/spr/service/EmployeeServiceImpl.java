package com.spr.service;

import com.spr.exception.EmployeeNotFound;
import com.spr.model.Employee;
import com.spr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional(rollbackFor=EmployeeNotFound.class)
    public Employee delete(int id) throws EmployeeNotFound {
        Employee employee = employeeRepository.findOne(id);

        if (employee == null)
            throw new EmployeeNotFound();

        employeeRepository.delete(employee);

        return employee;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor=EmployeeNotFound.class)
    public Employee update(Employee employee) throws EmployeeNotFound {
        Employee employeeUpdated = employeeRepository.findOne(employee.getId());

        if(employee == null)
            throw new EmployeeNotFound();

        employeeUpdated.setLastName(employee.getLastName());
        employeeUpdated.setName(employee.getName());
        employeeRepository.save(employeeUpdated);

        return employeeUpdated;
    }

    @Override
    @Transactional
    public Employee findById(int id) throws EmployeeNotFound{
        Employee employee = employeeRepository.findOne(id);

        if (employee == null)
            throw new EmployeeNotFound();

        return employee;
    }

    @Override
    public List<Employee> findByName(String name) throws EmployeeNotFound {
        List<Employee> employee = employeeRepository.findByName(name);

        if (employee == null)
            throw new EmployeeNotFound();

        return employee;
    }

    @Override
    @Transactional
    public List<Employee> searchByName(String name) throws EmployeeNotFound {
        List<Employee> employees = employeeRepository.searchByName(name);

        if (employees == null)
            throw new EmployeeNotFound();

        return employees;
    }
}
