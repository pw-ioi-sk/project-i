package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDAO;
import org.example.modal.Employee;

import java.io.IOException;

@WebServlet("/employee/save")
public class EmployeeSaveServlet extends HttpServlet {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        Double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = new Employee(name, branch, salary);

        employeeDAO.save(employee);

        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
