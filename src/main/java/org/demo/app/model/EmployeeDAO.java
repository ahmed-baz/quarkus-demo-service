package org.demo.app.model;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeDAO extends BaseDTO {

    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal salary;
    private LocalDate joinDate;

}
