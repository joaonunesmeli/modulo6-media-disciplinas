package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import bootcamp.java.mod6.school.util.AverageMessage;

import java.util.Arrays;
import java.util.List;

public final class CertificateServiceImplTestUtil {
    private CertificateServiceImplTestUtil() {}

    public static DiplomaDTO createValidDiplomaBelow9DTO() {
        StudentDTO s = createValidStudentBelow9DTO();
        double avg = avergage(s.getSubjects());
        return new DiplomaDTO(AverageMessage.BELOW_NINE, avg, s);
    }

    public static DiplomaDTO createValidDiplomaMaxDTO() {
        StudentDTO s = createValidStudentMaxDTO();
        double avg = avergage(s.getSubjects());
        return new DiplomaDTO(AverageMessage.BELOW_NINE, avg, s);
    }

    public static StudentDTO createValidStudentBelow9DTO() {
        StudentDTO s = new StudentDTO();
        s.setName("Luís Alves de Lima e Silva");
        s.setSubjects(createBelow9AverageSubjectList());
        return s;
    }

    public static StudentDTO createValidStudentMaxDTO() {
        StudentDTO s = new StudentDTO();
        s.setName("Luís Alves de Lima e Silva");
        s.setSubjects(createMaxAverageSubjectList());
        return s;
    }

    public static List<SubjectDTO> createZeroAverageSubjectList() {
        List<SubjectDTO> subs = createSubjectList();
        updateNotes(subs, 0);
        return subs;
    }

    // public static List<SubjectDTO> createBelow7AverageSubjectList() {
    //     List<SubjectDTO> subs = createSubjectList();
    //     updateNotes(subs, 6);
    //     return subs;
    // }

    public static List<SubjectDTO> createBelow9AverageSubjectList() {
        List<SubjectDTO> subs = createSubjectList();
        updateNotes(subs, 8);
        return subs;
    }

    public static List<SubjectDTO> createMaxAverageSubjectList() {
        List<SubjectDTO> subs = createSubjectList();
        updateNotes(subs, 10);
        return subs;
    }

    public static void updateNotes(List<SubjectDTO> subs, int n) {
        for (SubjectDTO s : subs) {
            s.setNote(n);
        }
    }

    public static List<SubjectDTO> createSubjectList() {
        return Arrays.asList(
                new SubjectDTO("Física"),
                new SubjectDTO("Matemática"),
                new SubjectDTO("Biologia"),
                new SubjectDTO("Português")
        );
    }

    public static double avergage(List<SubjectDTO> subs) {
        double avg = 0.0;
        for (SubjectDTO sub : subs) {
            avg += sub.getNote();
        }
        return avg / subs.size();
    }
}
