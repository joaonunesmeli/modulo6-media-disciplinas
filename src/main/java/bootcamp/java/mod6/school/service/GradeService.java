package bootcamp.java.mod6.school.service;

import bootcamp.java.mod6.school.util.AverageMessage;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    public String withHonors(double grade) {
        if (grade == 0.0) {
            return AverageMessage.EQ_ZERO;
        }
        if (grade < 7.0) {
            return AverageMessage.BELOW_SEVEN;
        }
        if (grade < 9.0) {
            return AverageMessage.BELOW_NINE;
        }
        return AverageMessage.MAX;
    }
}
