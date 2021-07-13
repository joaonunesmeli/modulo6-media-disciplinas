package bootcamp.java.mod6.school.controller;

import bootcamp.java.mod6.school.dto.Subject;
import bootcamp.java.mod6.school.dto.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {
    @PostMapping("/analyzeNotes")
    public Response media(@RequestBody @Valid Student s) {
        Response r = new Response("", 0.0, new Student());
        if (s == null) {
            return r;
        }

        r.setStudent(s);
        if (s.getSubjects().size() < 1) {
            r.setMessage("Se ainda não estudou nada, por que está aqui?");
            return r;
        }

        double media = 0.0;
        for (Subject d : s.getSubjects()) {
            media += d.getNote();
        }
        media /= s.getSubjects().size();
        r.setAverage(media);

        if (media == 0.0) {
            r.setMessage("Desista...");
        } else if (media < 7.0) {
            r.setMessage("Não conseguiu nem ficar na média... Nos vemos ano que vem de novo.");
        } else if (media <= 9.0) {
            r.setMessage("A média não está acima de 9 'mais' 'tá' 'safe'. Próximo na fila!");
        } else {
            r.setMessage("Parabéns! Não fez mais do que a sua obrigação!");
        }
        return r;
    }
}
