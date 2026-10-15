package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;

@WebServlet("/employee/delete")
public class EmployeeDeleteServlet extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Employee employee = employeeDao.findById(id);

        if (employee == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "EMPLOYEE NOT FOUND!");
            return;
        }

        employeeDao.delete(id);
        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
