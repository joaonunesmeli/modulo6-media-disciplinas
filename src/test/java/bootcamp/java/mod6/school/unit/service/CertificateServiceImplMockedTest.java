package bootcamp.java.mod6.school.unit.service;

import bootcamp.java.mod6.school.dto.DiplomaDTO;
import bootcamp.java.mod6.school.dto.StudentDTO;
import bootcamp.java.mod6.school.service.DiplomaService;
import bootcamp.java.mod6.school.service.GradeService;
import bootcamp.java.mod6.school.service.SubjectService;
import bootcamp.java.mod6.school.util.AverageMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class CertificateServiceImplMockedTest {
    private SubjectService subjectService = mock(SubjectService.class);
    private GradeService gradeService = mock(GradeService.class);

    private DiplomaService service;

    @BeforeEach
    void init() {
        this.service = new DiplomaService(gradeService, subjectService);
    }

    @Test
    public void DiplomaService_writeDiploma_ShouldCall_EachSubserviceOnce() {
        // Arrange
        when(
                // Esse teste só está interessado em saber quantas vezes cada
                // subserviço será chamado, então o input não faz diferença.
                subjectService.calculateAverage(eq(null))
        ).thenReturn(0.0);

        when(
                gradeService.withHonors(eq(0.0))
        ).thenReturn(AverageMessage.EQ_ZERO);

        // Act
        DiplomaDTO result = service.writeDiploma(new StudentDTO());

        // Assert
        verify(subjectService, times(1)).calculateAverage(eq(null));
        verify(gradeService, times(1)).withHonors(eq(0.0));
    }

    @Test
    public void DiplomaService_writeDiploma_ShouldReturn_ValidZeroDiploma() {
        // Arrange
        DiplomaDTO expected = TestUtil.createValidDiplomaEquals0DTO();
        StudentDTO input = expected.getStudent();

        when(
                subjectService.calculateAverage(eq(input.getSubjects()))
        ).thenReturn(0.0);

        when(
                gradeService.withHonors(eq(0.0))
        ).thenReturn(AverageMessage.EQ_ZERO);

        // Act
        DiplomaDTO result = service.writeDiploma(input);

        // Assert
        Assertions.assertEquals(expected.getAverage(), result.getAverage());
        Assertions.assertEquals(expected.getStudent(), result.getStudent());
        Assertions.assertEquals(expected.getMessage(), result.getMessage());
    }
}
