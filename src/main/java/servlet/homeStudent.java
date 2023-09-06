package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "homeStudent", value = "/home")
public class homeStudent extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = null;
        try {
            studentList = studentDAO.getAllStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("students", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeStudent.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}