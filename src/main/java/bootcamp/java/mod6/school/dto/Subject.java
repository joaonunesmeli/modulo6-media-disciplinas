package bootcamp.java.mod6.school.dto;

public class Subject {
    private String name;
    private double note;

    public Subject() {
    }

    public Subject(String name, double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
