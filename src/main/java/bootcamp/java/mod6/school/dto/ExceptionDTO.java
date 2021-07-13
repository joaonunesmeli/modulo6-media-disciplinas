package bootcamp.java.mod6.school.dto;

import java.util.Map;

public class ExceptionDTO {
    Map<String, String> errors;

    public ExceptionDTO(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
