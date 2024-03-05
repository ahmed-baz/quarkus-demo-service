package org.demo.app.service.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.demo.app.entity.Employee;
import org.demo.app.mapper.BaseMapper;
import org.demo.app.mapper.EmployeeMapper;
import org.demo.app.model.EmployeeDAO;
import org.demo.app.repo.EmployeeRepo;
import org.demo.app.service.EmployeeService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl extends AppManagerImpl<Employee, EmployeeDAO> implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepo employeeRepo;

    @Override
    public EmployeeDAO findEmployeeById(Long id) {
        return findById(id);
    }

    @Override
    public List<EmployeeDAO> findEmployees() {
        return findAll();
    }

    @Override
    public EmployeeDAO createEmployee(EmployeeDAO employee) {
        if (employee.getJoinDate() == null) employee.setJoinDate(LocalDate.now());
        return add(employee);
    }

    @Override
    public List<EmployeeDAO> createEmployee(List<EmployeeDAO> employees) {
        List<Employee> employeeList = employeeMapper.dtoListToEntityList(employees);
        employeeRepo.persist(employeeList);
        return employeeMapper.entityListToDtoList(employeeList);
    }

    @Override
    public EmployeeDAO updateEmployee(Long id, EmployeeDAO employeeDAO) {
        return update(id, employeeDAO);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return delete(id);
    }

    @Override
    public BaseMapper<Employee, EmployeeDAO> getMapper() {
        return employeeMapper;
    }

    @Override
    public PanacheRepository getRepo() {
        return employeeRepo;
    }
}
