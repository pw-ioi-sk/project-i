package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.dao.EmployeeDAO;
import org.example.modal.Employee;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        List<Employee> employees = employeeDAO.findAll();

        ThymeleafConfig.render(
                req,
                res,
                Map.of("employees", employees),
                "employee");

        // /employee/add
    }
}
