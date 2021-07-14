package bootcamp.java.mod6.school.util;

import bootcamp.java.mod6.school.dto.SubjectDTO;

import java.util.List;

public final class DiplomaUtil {
    private DiplomaUtil() {}

    public static double calculateAverage(List<SubjectDTO> subjects) {
        double sum = 0.0;
        for (SubjectDTO s : subjects) {
            sum += s.getNote();
        }
        return sum / subjects.size();
    }

    public static String withHonors(double grade) {
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
