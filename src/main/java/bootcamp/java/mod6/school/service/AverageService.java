package bootcamp.java.mod6.school.service;

import bootcamp.java.mod6.school.dto.ResponseDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AverageService {
    public ResponseDTO average(StudentDTO s) {
        double average = getAverage(s.getSubjects());
        String message = getMessage(average);
        return new ResponseDTO(message, average, s);
    }

    private double getAverage(List<SubjectDTO> subs) {
        double avg = 0.0;
        for (SubjectDTO s : subs) {
            avg += s.getNote();
        }
        return avg / subs.size();
    }

    private String getMessage(double average) {
        if (average == 0.0) {
            return "Desista...";
        }
        if (average < 7.0) {
            return "Não conseguiu nem ficar na média... Nos vemos ano que vem de novo.";
        }
        if (average <= 9.0) {
            return "A média não está acima de 9 'mais' 'tá' 'safe'. Próximo na fila!";
        }
        return "Parabéns! Não fez mais do que a sua obrigação!";
    }
}
