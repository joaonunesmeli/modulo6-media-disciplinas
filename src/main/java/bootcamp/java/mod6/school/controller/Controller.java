package bootcamp.java.mod6.school.controller;

import bootcamp.java.mod6.school.dto.Disciplina;
import bootcamp.java.mod6.school.dto.Estudante;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping("media")
    public Response media(@RequestBody Estudante e) {
        Response r = new Response("", 0.0, "");
        if (e == null) {
            return r;
        }

        r.setAluno(e.getNome());
        if (e.getDisciplinas().size() < 1) {
            r.setMensagem("Se ainda não estudou nada, por que está aqui?");
            return r;
        }

        double media = 0.0;
        for (Disciplina d : e.getDisciplinas()) {
            media += d.getNota();
        }
        media /= e.getDisciplinas().size();
        r.setMedia(media);

        if (media == 0.0) {
            r.setMensagem("Desista...");
        } else if (media < 7.0) {
            r.setMensagem("Não conseguiu nem ficar na média... Nos vemos ano que vem de novo.");
        } else if (media <= 9.0) {
            r.setMensagem("A média não está acima de 9 'mais' 'tá' 'safe'. Próximo na fila!");
        } else {
            r.setMensagem("Parabéns! Não fez mais do que a sua obrigação!");
        }
        return r;
    }
}
