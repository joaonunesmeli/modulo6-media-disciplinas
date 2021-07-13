package bootcamp.java.mod6.school.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class Student {
    @NotNull(message = "O nome é um campo obrigatório")
    @Min(value = 8, message = "Nome muito curto, ele deve ter no mínimo 8 caracteres")
    @Max(value = 50, message = "Nome muito longo, ele deve ter no máximo 50 caracteres")
    @Pattern(regexp = "[a-z]+", message = "O nome só pode conter caracteres de 'a' à 'z'")
    private String name;

    @NotNull(message = "A lista de disciplinas é um campo obrigatório")
    private List<Subject> subjects;

    public Student() {
    }

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
