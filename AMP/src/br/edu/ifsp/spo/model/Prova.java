package br.edu.ifsp.spo.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Prova {

    private int idProva;
    private String nomeProva;
    private File cadernoProva;
    private List<Exercicio> exercicios;

    public Prova(int idProva, String nomeProva, File cadernoProva) {
        this.idProva = idProva;
        this.nomeProva = nomeProva;
        this.cadernoProva = cadernoProva;
        this.exercicios = new ArrayList<>();
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public String getNomeProva() {
        return nomeProva;
    }

    public void setNomeProva(String nomeProva) {
        this.nomeProva = nomeProva;
    }

    public File getCadernoProva() {
        return cadernoProva;
    }

    public void setCadernoProva(File cadernoProva) {
        this.cadernoProva = cadernoProva;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

}
