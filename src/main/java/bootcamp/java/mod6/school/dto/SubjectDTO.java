package bootcamp.java.mod6.school.dto;

import javax.validation.constraints.*;

public class SubjectDTO {
    @NotNull(message = "O nome é um campo obrigatório")
    @Pattern(regexp = "[a-z]+", message = "O nome só pode conter caracteres de 'a' à 'z'")
    @Size(min = 8, max = 50, message = "O nome deve ter entre 8 e 50 caracteres")
    private String name;

    @Min(value = 0, message = "A nota não deve ser menor do que zero")
    @Max(value = 99, message = "A nota não deve ser maior do que noventa e nove")
    private int note;

    public SubjectDTO() {
    }

    public SubjectDTO(String name) {
        this.name = name;
    }

    public SubjectDTO(String name, int note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(SubjectDTO.class)) {
            return false;
        }
        SubjectDTO s = (SubjectDTO) obj;
        return this.name.equals(s.name) && this.note == s.note;
    }
}
