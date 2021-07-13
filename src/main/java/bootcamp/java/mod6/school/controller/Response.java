package bootcamp.java.mod6.school.controller;

import bootcamp.java.mod6.school.dto.Student;

public class Response {
    private String message;
    private double average;
    private Student student;

    public Response(String message, double average, Student student) {
        this.message = message;
        this.average = average;
        this.student = student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
