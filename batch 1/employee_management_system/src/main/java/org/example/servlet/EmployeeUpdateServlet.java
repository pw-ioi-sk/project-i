package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;

@WebServlet("/employee/saveas")
public class EmployeeUpdateServlet extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String dept = req.getParameter("dept");
        Double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = employeeDao.findById(id);

        if (employee == null) {
            res.sendError(404, "NOT FOUND!");
            return;
        }

        employee.setName(name);
        employee.setDept(dept);
        employee.setSalary(salary);
        employeeDao.update(employee);

        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
