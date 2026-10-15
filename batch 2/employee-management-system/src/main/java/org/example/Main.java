package org.example;

import org.example.dao.EmployeeDAO;
import org.example.modal.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

//        Employee employee = employeeDAO.findById(18);
//        employee.setName("Virat Kohli");
//        employee.setBranch("Cricket");
//        employee.setSalary(709876);
//        employeeDAO.update(employee);

        employeeDAO.delete(18);

        List<Employee> employees = employeeDAO.findAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
}
