package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import bootcamp.java.mod6.school.service.DiplomaService;
import bootcamp.java.mod6.school.util.AverageMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Arrays;
import java.util.List;

public class CertificateServiceImplTest {
    private DiplomaService service = new DiplomaService();

    @Test
    public void shouldThrowNullPointerException() {
        // Arrange
        StudentDTO s = new StudentDTO();

        // Act
        Executable act = () -> this.service.writeDiploma(s);

        // Assert
        NullPointerException ex = Assertions.assertThrows(NullPointerException.class, act);
        Assertions.assertNotNull(ex);
    }

    @Test
    public void shouldReturnStudentDTO() {
        // Arrange
        StudentDTO s = createValidStudentBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotNull(response);
    }

    @Test
    public void shouldReturnValidResponse() {
        // Arrange
        StudentDTO s = createValidStudentBelow9DTO();
        DiplomaDTO expected = createValidResponseBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertEquals(response, expected);
    }

    @Test
    public void shouldAssertNotEquals() {
        // Arrange
        StudentDTO s = createValidStudentBelow9DTO();
        DiplomaDTO expected = createValidResponseMaxDTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotEquals(response, expected);
    }

    private DiplomaDTO createValidResponseBelow9DTO() {
        StudentDTO s = createValidStudentBelow9DTO();
        double avg = avergage(s.getSubjects());
        return new DiplomaDTO(AverageMessage.BELOW_NINE, avg, s);
    }

    private DiplomaDTO createValidResponseMaxDTO() {
        StudentDTO s = createValidStudentMaxDTO();
        double avg = avergage(s.getSubjects());
        return new DiplomaDTO(AverageMessage.BELOW_NINE, avg, s);
    }

    private StudentDTO createValidStudentBelow9DTO() {
        StudentDTO s = new StudentDTO();
        s.setName("Luís Alves de Lima e Silva");
        s.setSubjects(
                Arrays.asList(
                        new SubjectDTO("Física", 10),
                        new SubjectDTO("Matemática", 5),
                        new SubjectDTO("Biologia", 10),
                        new SubjectDTO("Português", 5)
                )
        );
        return s;
    }

    private StudentDTO createValidStudentMaxDTO() {
        StudentDTO s = new StudentDTO();
        s.setName("Luís Alves de Lima e Silva");
        s.setSubjects(
                Arrays.asList(
                        new SubjectDTO("Física", 10),
                        new SubjectDTO("Matemática", 10),
                        new SubjectDTO("Biologia", 10),
                        new SubjectDTO("Português", 10)
                )
        );
        return s;
    }

    private double avergage(List<SubjectDTO> subs) {
        double avg = 0.0;
        for (SubjectDTO sub : subs) {
            avg += sub.getNote();
        }
        return avg / subs.size();
    }
}
