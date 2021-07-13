package bootcamp.java.mod6.school.exception.handler;

import bootcamp.java.mod6.school.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDTO handle(MethodArgumentNotValidException e) {
        List<FieldError> boundErrors = e.getBindingResult().getFieldErrors();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fe : boundErrors) {
            errors.put(fe.getField(), fe.getDefaultMessage());
        }
        return new ExceptionDTO(errors);
    }
}
