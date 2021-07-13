package bootcamp.java.mod6.school.controller;

import bootcamp.java.mod6.school.dto.ResponseDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.service.AverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {
    private final AverageService service;

    @Autowired
    public Controller(AverageService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/analyzeNotes")
    public ResponseDTO analyzeNotes(@Valid @RequestBody StudentDTO s) {
        return this.service.average(s);
    }
}
