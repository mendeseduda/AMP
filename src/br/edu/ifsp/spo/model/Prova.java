package br.edu.ifsp.spo.model;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Prova {

    private int idProva;
    private String nomeProva;
    private File cadernoProva;
    private ObservableList<Exercicio> exercicios;

    public Prova(int idProva, String nomeProva, File cadernoProva) {
        this.idProva = idProva;
        this.nomeProva = nomeProva;
        this.cadernoProva = cadernoProva;
        this.exercicios = FXCollections.observableArrayList();
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

    public ObservableList<Exercicio> getExercicios() {
		return exercicios;
	}

    public void setExercicios(ObservableList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

}
