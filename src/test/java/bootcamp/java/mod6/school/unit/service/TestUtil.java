package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import bootcamp.java.mod6.school.util.AverageMessage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

final class TestUtil {
    private TestUtil() {}

    public static DiplomaDTO createValidDiplomaEquals0DTO() {
        return createBasicDiploma(TestUtil::createValidStudentEquals0DTO, AverageMessage.EQ_ZERO);
    }

    public static DiplomaDTO createValidDiplomaBelow9DTO() {
        return createBasicDiploma(TestUtil::createValidStudentBelow9DTO, AverageMessage.BELOW_NINE);
    }

    public static DiplomaDTO createValidDiplomaMaxDTO() {
        return createBasicDiploma(TestUtil::createValidStudentMaxDTO, AverageMessage.BELOW_NINE);
    }

    public static StudentDTO createValidStudentEquals0DTO() {
        return createBasicStudentDTO(TestUtil::createZeroAverageSubjectList);
    }

    public static StudentDTO createValidStudentBelow9DTO() {
        return createBasicStudentDTO(TestUtil::createBelow9AverageSubjectList);
    }

    public static StudentDTO createValidStudentMaxDTO() {
        return createBasicStudentDTO(TestUtil::createMaxAverageSubjectList);
    }

    public static List<SubjectDTO> createZeroAverageSubjectList() {
        return createSubjectList(0);
    }

    public static List<SubjectDTO> createBelow9AverageSubjectList() {
        return createSubjectList(8);
    }

    public static List<SubjectDTO> createMaxAverageSubjectList() {
        return createSubjectList(10);
    }

    private static List<SubjectDTO> createSubjectList(int grade) {
        return Arrays.asList(
                new SubjectDTO("matematica", grade),
                new SubjectDTO("portugues", grade),
                new SubjectDTO("biologia", grade)
        );
    }

    private static double avergage(List<SubjectDTO> subs) {
        double avg = 0.0;
        for (SubjectDTO sub : subs) {
            avg += sub.getNote();
        }
        return avg / subs.size();
    }

    private static StudentDTO createBasicStudentDTO(Supplier<List<SubjectDTO>> fn) {
        StudentDTO s = new StudentDTO("luisalvesdelimaesilva");
        s.setSubjects(fn.get());
        return s;
    }

    private static DiplomaDTO createBasicDiploma(Supplier<StudentDTO> fn, String message) {
        StudentDTO s = fn.get();
        double avg = avergage(s.getSubjects());
        return new DiplomaDTO(message, avg, s);
    }
}
