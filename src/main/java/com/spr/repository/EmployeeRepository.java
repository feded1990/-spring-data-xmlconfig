package com.spr.repository;

import com.spr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    @Query(value = "SELECT * FROM employees WHERE name LIKE %:searchTerm%", nativeQuery = true)
    List<Employee> searchByName(@Param("searchTerm") String name);
}
