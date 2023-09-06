package dao;

import model.ClassRoom;
import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thithmd3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";
    private Connection jdbcConnection;

    public StudentDAO() {
    }

    private void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    private void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Student> getAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("select s.*, c.name from student s join classroom c on s.classroomId = c.id;");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("s.name");
            String email = resultSet.getString("email");
            LocalDate birthday = LocalDate.parse(resultSet.getString("birthDay"));
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            int idClassRoom = resultSet.getInt("classroomId");
            String nameClassroom = resultSet.getString("c.name");
            ClassRoom classRoom = new ClassRoom(idClassRoom, nameClassroom);
            Student student = new Student(id, name, birthday, address, email, phone, classRoom);
            students.add(student);
        }
        return students;
    }

    public void addStudent(Student student) throws SQLException {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement("insert into student (name, email, birthDay, address, phone,classroomId) VALUES (?,?,?,?,?,?);");
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setDate(3, Date.valueOf(student.getBirthDay()));
        statement.setString(4, student.getAddress());
        statement.setString(5, student.getPhone());
        statement.setInt(6, student.getIdClassroom().getId());
        statement.executeUpdate();
    }

    public void deteleStudent(int id) throws SQLException {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement("delete from student where id=?;");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public Student getStudentById(int id) throws SQLException {
        Student student = null;
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement("select * from student where id = ?;");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int idStudent = resultSet.getInt("id");
            String name = resultSet.getString("name");
            LocalDate date = LocalDate.parse(resultSet.getString("birthDay"));
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            int idClassroom = resultSet.getInt("classroomId");
            ClassRoom classRoom = new ClassRoom(idClassroom);
            student = new Student(idStudent, name, date, address, email, phone, classRoom);

        }
        return student;
    }

    public void updateStudent(Student student) throws SQLException {
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement("UPDATE student set name = ?, birthDay = ?, address = ?, email = ?, phone = ?, classroomId = ? where  id = ?;");
        statement.setString(1, student.getName());
        statement.setDate(2, Date.valueOf(student.getBirthDay()));
        statement.setString(3, student.getAddress());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPhone());
        statement.setInt(5, student.getIdClassroom().getId());
        statement.setInt(6, student.getId());
        statement.executeUpdate();
    }

    public List<Student> sortByName(String name) throws SQLException {
        List<Student> sortedStudents = new ArrayList<>();
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement("SELECT s.*, c.name FROM student s JOIN class c ON c.id = s.classroomId WHERE s.name LIKE ?;");
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String studentName = resultSet.getString("name");
            LocalDate birthday = LocalDate.parse(resultSet.getString("birthDay"));
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            int idClassRoom = resultSet.getInt("classroomId");
            String nameClassroom = resultSet.getString("c.name");
            ClassRoom classRoom = new ClassRoom(idClassRoom, nameClassroom);
            Student student = new Student(id, studentName, birthday, address, email, phone, classRoom);
            sortedStudents.add(student);
        }
        return sortedStudents;
    }
}
