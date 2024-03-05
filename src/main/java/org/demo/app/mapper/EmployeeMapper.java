package org.demo.app.mapper;

import org.demo.app.entity.Employee;
import org.demo.app.model.EmployeeDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDAO> {
}
