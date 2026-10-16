package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.modal.Employee;

import java.io.IOException;
import java.util.Map;

@WebServlet("/employee/add")
public class EmployeeFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        ThymeleafConfig.render(
                req,
                res,
                Map.of("employee", new Employee()),
                "add-new-employee");
    }
}
