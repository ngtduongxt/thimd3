package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "sortByName", value = "/sortByName")
public class sortByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = null;
        try {
            students = studentDAO.sortByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("students", students);

        request.getRequestDispatcher("/homeStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}