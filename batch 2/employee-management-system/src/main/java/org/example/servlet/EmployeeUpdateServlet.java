package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDAO;
import org.example.modal.Employee;

import java.io.IOException;
import java.util.Locale;

@WebServlet("/employee/modify")
public class EmployeeUpdateServlet extends HttpServlet {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        Double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = employeeDAO.findById(id);

        if (employee == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "EMPLOYEE NOT FOUND!");
            return;
        }

        employee.setName(name);
        employee.setSalary(salary);
        employee.setBranch(branch);

        employeeDAO.update(employee);

        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
