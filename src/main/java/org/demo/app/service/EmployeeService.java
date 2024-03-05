package org.demo.app.service;

import org.demo.app.model.EmployeeDAO;

import java.util.List;

public interface EmployeeService {

    EmployeeDAO findEmployeeById(Long id);

    List<EmployeeDAO> findEmployees();

    EmployeeDAO createEmployee(EmployeeDAO employee);

    List<EmployeeDAO> createEmployee(List<EmployeeDAO> employees);

    EmployeeDAO updateEmployee(Long id, EmployeeDAO employee);

    boolean deleteEmployee(Long id);
}
