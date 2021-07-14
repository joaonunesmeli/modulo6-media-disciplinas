package bootcamp.java.mod6.school.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {
    private GradeService gradeService;
    private SubjectService subjectService;

    @Autowired
    public DiplomaService(GradeService gradeService, SubjectService subjectService) {
        this.gradeService = gradeService;
        this.subjectService = subjectService;
    }

    public DiplomaDTO writeDiploma(StudentDTO s) {
        double average = this.subjectService.calculateAverage(s.getSubjects());
        String message = this.gradeService.withHonors(average);
        return new DiplomaDTO(message, average, s);
    }
}
