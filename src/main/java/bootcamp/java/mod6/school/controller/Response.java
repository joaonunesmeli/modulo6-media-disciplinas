package bootcamp.java.mod6.school.controller;

public class Response {
    private String mensagem;
    private double media;
    private String aluno;

    public Response(String mensagem, double media, String aluno) {
        this.mensagem = mensagem;
        this.media = media;
        this.aluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
