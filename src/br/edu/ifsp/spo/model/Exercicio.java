package br.edu.ifsp.spo.model;

public class Exercicio {

    private final int idExercicio; // codigo do exercicio no sistema
    private String nome;
    private String nomeArquivo;
    private Prova prova;

    public Exercicio(int idExercicio, String nome, String nomeArquivo, Prova prova) {
        this.idExercicio = idExercicio;
        this.nome = nome;
        this.nomeArquivo = nomeArquivo;
        this.prova = prova;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

}
