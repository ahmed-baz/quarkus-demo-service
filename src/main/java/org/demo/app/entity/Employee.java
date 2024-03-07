package org.demo.app.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
public class Employee extends PanacheEntity {

    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "join_date")
    @Temporal(TemporalType.DATE)
    private LocalDate joinDate;

}
