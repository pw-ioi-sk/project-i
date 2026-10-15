package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDAO;

import java.io.IOException;

@WebServlet("/employee/delete")
public class EmployeeDelete extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        employeeDAO.delete(id);

        res.sendRedirect(req.getContextPath() + "/employees");
    }
}
