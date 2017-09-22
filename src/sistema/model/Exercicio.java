/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.model;

/**
 *
 * @author Roberto Bolgheroni
 */
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
