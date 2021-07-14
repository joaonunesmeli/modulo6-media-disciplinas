package bootcamp.java.mod6.school.unit.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import bootcamp.java.mod6.school.dto.StudentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerTest {

    @Autowired
    private MockMvc mock;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void Controller_analyzeNotes_ShouldExpect_BadRequest() throws Exception {
        String payload = mapper.writeValueAsString(new StudentDTO());

        mock.perform(
                post("/analyzeNotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void Controller_analyzeNotes_ShouldThrow_Created() throws Exception {
        StudentDTO s = TestUtil.createValidStudentBelow9DTO();
        String payload = mapper.writeValueAsString(s);

        mock.perform(
                post("/analyzeNotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        ).andExpect(status().isCreated());
    }

}
