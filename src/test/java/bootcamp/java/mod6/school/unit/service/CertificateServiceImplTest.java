package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.service.DiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

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
}
