package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import bootcamp.java.mod6.school.service.DiplomaService;
import bootcamp.java.mod6.school.util.AverageMessage;
import bootcamp.java.mod6.school.util.DiplomaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.List;

public class CertificateServiceImplTest {
    private final DiplomaService service = new DiplomaService();

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
        StudentDTO s = CertificateServiceImplTestUtil.createValidStudentBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotNull(response);
    }

    @Test
    public void shouldReturnValidResponse() {
        // Arrange
        StudentDTO s = CertificateServiceImplTestUtil.createValidStudentBelow9DTO();
        DiplomaDTO expected = CertificateServiceImplTestUtil.createValidDiplomaBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertEquals(response, expected);
    }

    @Test
    public void shouldAssertNotEquals() {
        // Arrange
        StudentDTO s = CertificateServiceImplTestUtil.createValidStudentBelow9DTO();
        DiplomaDTO expected = CertificateServiceImplTestUtil.createValidDiplomaMaxDTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotEquals(response, expected);
    }

    @Test
    public void shouldCalculateAverageZero() {
        // Arrange
        List<SubjectDTO> s = CertificateServiceImplTestUtil.createZeroAverageSubjectList();
        double expected = 0.0;

        // Act
        double result = DiplomaUtil.calculateAverage(s);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldGetZeroHonor() {
        // Arrange
        List<SubjectDTO> s = CertificateServiceImplTestUtil.createZeroAverageSubjectList();
        String expected = AverageMessage.EQ_ZERO;

        // Act
        double avg = DiplomaUtil.calculateAverage(s);
        String result = DiplomaUtil.withHonors(avg);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
