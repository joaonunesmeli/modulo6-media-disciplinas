package bootcamp.java.mod6.school.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.util.DiplomaUtil;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {
    public DiplomaDTO writeDiploma(StudentDTO s) {
        double average = DiplomaUtil.calculateAverage(s.getSubjects());
        String message = DiplomaUtil.withHonors(average);
        return new DiplomaDTO(message, average, s);
    }
}
