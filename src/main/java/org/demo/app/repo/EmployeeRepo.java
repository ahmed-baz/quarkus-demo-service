package org.demo.app.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.demo.app.entity.Employee;


@ApplicationScoped
public class EmployeeRepo implements PanacheRepository<Employee> {
}
