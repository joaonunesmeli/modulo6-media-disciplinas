package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.dto.SubjectDTO;
import bootcamp.java.mod6.school.service.DiplomaService;
import bootcamp.java.mod6.school.service.GradeService;
import bootcamp.java.mod6.school.service.SubjectService;
import bootcamp.java.mod6.school.util.AverageMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.List;

public class CertificateServiceImplTest {
    private final GradeService gradeService = new GradeService();
    private final SubjectService subjectService = new SubjectService();
    private final DiplomaService service = new DiplomaService(gradeService, subjectService);

    @Test
    public void DiplomaService_writeDiploma_Should_Throw_NullPointerException() {
        // Arrange
        StudentDTO s = new StudentDTO();

        // Act
        Executable act = () -> this.service.writeDiploma(s);

        // Assert
        NullPointerException ex = Assertions.assertThrows(NullPointerException.class, act);
        Assertions.assertNotNull(ex);
    }

    @Test
    public void DiplomaService_writeDiploma_Should_Return_StudentDTO() {
        // Arrange
        StudentDTO s = TestUtil.createValidStudentBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotNull(response);
    }

    @Test
    public void DiplomaService_writeDiploma_ShouldReturn_DiplomaDTO() {
        // Arrange
        StudentDTO s = TestUtil.createValidStudentBelow9DTO();
        DiplomaDTO expected = TestUtil.createValidDiplomaBelow9DTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertEquals(response, expected);
    }

    @Test
    public void DiplomaService_writeDiploma_ShouldAssert_NotEquals() {
        // Arrange
        StudentDTO s = TestUtil.createValidStudentBelow9DTO();
        DiplomaDTO expected = TestUtil.createValidDiplomaMaxDTO();

        // Act
        ThrowingSupplier<DiplomaDTO> act = () -> this.service.writeDiploma(s);

        // Assert
        DiplomaDTO response = Assertions.assertDoesNotThrow(act);
        Assertions.assertNotEquals(response, expected);
    }

    @Test
    public void SubjectService_calculateAverage_ShouldAssert_Equals() {
        // Arrange
        List<SubjectDTO> s = TestUtil.createZeroAverageSubjectList();
        double expected = 0.0;

        // Act
        double result = this.subjectService.calculateAverage(s);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void GradeService_withHonors_ShouldAssert_Equals() {
        // Arrange
        List<SubjectDTO> s = TestUtil.createZeroAverageSubjectList();
        String expected = AverageMessage.EQ_ZERO;

        // Act
        double avg = this.subjectService.calculateAverage(s);
        String result = this.gradeService.withHonors(avg);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
