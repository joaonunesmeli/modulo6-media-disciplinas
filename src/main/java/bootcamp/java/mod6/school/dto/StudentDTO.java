package bootcamp.java.mod6.school.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class StudentDTO {
    @NotNull(message = "O nome é um campo obrigatório")
    @Pattern(regexp = "[a-z]+", message = "O nome só pode conter caracteres de 'a' à 'z'")
    @Size(min = 8, max = 50, message = "O nome deve ter entre 8 e 50 caracteres")
    private String name;

    @NotNull(message = "A lista de disciplinas é um campo obrigatório")
    @Size(min = 1, message = "Forneça ao menos umas disciplina")
    @Valid
    private List<SubjectDTO> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(StudentDTO.class)) {
            return false;
        }
        StudentDTO s = (StudentDTO) obj;
        return this.name.equals(s.name) && this.subjects.equals(s.subjects);
    }
}
