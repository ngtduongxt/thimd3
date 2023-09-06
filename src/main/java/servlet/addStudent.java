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

@WebServlet(name = "addStudent", value = "/addStudent")
public class addStudent extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addStudent.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        LocalDate birthDay = LocalDate.parse(request.getParameter("birthDay"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        int idClassroom = Integer.parseInt(request.getParameter("classid"));
        ClassRoom classRoom = new ClassRoom(idClassroom);
        Student student = new Student(name, birthDay, address, email,phone, classRoom);
        try {
            studentDAO.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/home");
    }
}
