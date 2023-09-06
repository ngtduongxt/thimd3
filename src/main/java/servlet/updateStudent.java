package servlet;

import dao.StudentDAO;
import model.ClassRoom;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "updateStudent", value = "/updateStudent")
public class updateStudent extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = null;
        try {
            student = studentDAO.getStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("student", student);
        request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate birthDay = LocalDate.parse(request.getParameter("birthDay"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int idClassroom = Integer.parseInt(request.getParameter("classid"));
        ClassRoom classRoom = new ClassRoom(idClassroom);
        Student student = new Student(id, name, birthDay, address, email, classRoom);
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/home");
    }
}