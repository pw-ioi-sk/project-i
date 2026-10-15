package org.example;


import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();

//        System.out.println(employeeDao.findById(50));

//        Employee employee = new Employee("Bawa", "SOT", 1234567);
//        employeeDao.save(employee);

//
//        employeeDao.delete(45);

//        Employee employee = employeeDao.findById(18);
//        employee.setDept("SWE");
//        employee.setSalary(5000000);
//
//        employeeDao.update(employee);

        List<Employee> employees = employeeDao.findAll();

        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
}
