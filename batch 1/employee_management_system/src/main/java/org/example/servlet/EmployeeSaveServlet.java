package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;

@WebServlet("/employee/save")
public class EmployeeSaveServlet extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String dept = req.getParameter("dept");
        Double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = new Employee(name, dept, salary);

        employeeDao.save(employee);

        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
