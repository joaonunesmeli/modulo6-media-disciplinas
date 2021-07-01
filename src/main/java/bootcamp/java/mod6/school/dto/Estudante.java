package bootcamp.java.mod6.school.dto;

import java.util.List;

public class Estudante {
    private String nome;
    private List<Disciplina> disciplinas;

    public Estudante() {
    }

    public Estudante(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
