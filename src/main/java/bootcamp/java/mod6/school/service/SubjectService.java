package bootcamp.java.mod6.school.service;

import bootcamp.java.mod6.school.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    public double calculateAverage(List<SubjectDTO> subjects) {
        double sum = 0.0;
        for (SubjectDTO s : subjects) {
            sum += s.getNote();
        }
        return sum / subjects.size();
    }

}
