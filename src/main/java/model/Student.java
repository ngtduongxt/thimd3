package model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private String email;
    private String phone;
    private ClassRoom idClassroom;

    public Student(String name, LocalDate birthDay, String address, String email, String phone, ClassRoom idClassroom) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.idClassroom = idClassroom;
    }

    public Student(int id, String name, LocalDate birthDay, String address, String email, String phone, ClassRoom idClassroom) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.idClassroom = idClassroom;
    }

    public Student(String name, LocalDate birthDay, String address, String email, ClassRoom idClassroom) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.idClassroom = idClassroom;
    }

    public Student(int id, String name, LocalDate birthDay, String address, String email, ClassRoom idClassroom) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.email = email;
        this.idClassroom = idClassroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassRoom getIdClassroom() {
        return idClassroom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdClassroom(ClassRoom idClassroom) {
        this.idClassroom = idClassroom;
    }
}
