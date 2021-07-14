package bootcamp.java.mod6.school.dto;

public class DiplomaDTO {
    private String message;
    private double average;
    private StudentDTO student;

    public DiplomaDTO(String message, double average, StudentDTO student) {
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

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(DiplomaDTO.class)) {
            return false;
        }
        DiplomaDTO r = (DiplomaDTO) obj;
        return this.message.equals(r.message)
                && this.average == r.average
                && this.student.equals(r.student);
    }
}
