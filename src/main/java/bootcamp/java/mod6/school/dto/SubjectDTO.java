package bootcamp.java.mod6.school.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SubjectDTO {
    @NotNull(message = "O nome é um campo obrigatório")
    @Min(value = 8, message = "Nome muito curto, ele deve ter no mínimo 8 caracteres")
    @Max(value = 50, message = "Nome muito longo, ele deve ter no máximo 50 caracteres")
    @Pattern(regexp = "[a-z]+", message = "O nome só pode conter caracteres de 'a' à 'z'")
    private String name;

    @Min(value = 0, message = "A nota não deve ser menor do que zero")
    @Max(value = 99, message = "A nota não deve ser maior do que noventa e nove")
    private int note;

    public SubjectDTO() {
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
}
