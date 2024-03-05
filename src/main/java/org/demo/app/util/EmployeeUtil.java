package org.demo.app.util;


import lombok.experimental.UtilityClass;
import org.demo.app.model.EmployeeDAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class EmployeeUtil {

    private final String[] names = {"Ahmed", "Ali", "Hassan", "Mohamed", "Said", "Saad", "Mostafa", "Ibrahim"};
    private final String[] mail = {"fawry.com", "gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "new.markets.com", "stc.com", "stc.pay.com"};
    private final int max = 7;
    private final int min = 0;

    public EmployeeDAO createRandomEmployee(Long id) {
        EmployeeDAO employeeDAO = createRandomEmployee();
        employeeDAO.setId(id);
        return employeeDAO;
    }

    public EmployeeDAO createRandomEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.setFirstName(names[getRandomIndex()]);
        employeeDAO.setLastName(names[getRandomIndex()]);
        String email = employeeDAO.getFirstName() + "." +
                employeeDAO.getLastName() + "_" +
                getRandomInt() + "@" +
                mail[getRandomIndex()];
        employeeDAO.setEmail(email.toLowerCase(Locale.ROOT));
        employeeDAO.setSalary(generateRandomSalary(5000, 50000));
        employeeDAO.setJoinDate(getRandomDate());
        return employeeDAO;
    }

    public BigDecimal generateRandomSalary(int min, int max) {
        int random = min + (int) (Math.random() * ((max - min) + 1));
        return BigDecimal.valueOf((random / 1000) * 1000);
    }

    public List<EmployeeDAO> getEmployeeList(int size) {
        List<EmployeeDAO> employeeDAOList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            employeeDAOList.add(createRandomEmployee());
        }
        return employeeDAOList;
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private Long getRandomId() {
        Random rand = new Random();
        return rand.nextLong();
    }

    private Integer getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(50000);
    }

    private LocalDate getRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.now().toEpochDay();
        long randomDay = random.nextInt(maxDay - minDay) + minDay;
        return LocalDate.ofEpochDay(randomDay);
    }

}
