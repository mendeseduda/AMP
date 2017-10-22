package br.edu.ifsp.spo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exercicio {

    private final IntegerProperty idExercicio;
    private final StringProperty nomeExercicio;
    private final StringProperty exercicioEnviado;
    private final StringProperty nomeArquivo;
    private final ObjectProperty<Prova> prova;

    public Exercicio(int idExercicio, String nome, String nomeArquivo, Prova prova) {
    	this.idExercicio = new SimpleIntegerProperty();
    	this.nomeExercicio = new SimpleStringProperty(nome);
    	this.exercicioEnviado = new SimpleStringProperty("Não");
    	this.nomeArquivo = new SimpleStringProperty(nomeArquivo);
    	this.prova = new SimpleObjectProperty<>(prova);
    }

    public Prova getProva() {
        return prova.get();
    }

    public void setProva(Prova prova) {
        this.prova.set(prova);
    }

    public ObjectProperty provaProperty(){
    	return prova;
    }

    public int getIdExercicio() {
        return idExercicio.get();
    }

    public void setIdExercicio(int idExercicio) {
		this.idExercicio.set(idExercicio);
	}

    public IntegerProperty IdExercicioProperty(){
    	return idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio.get();
    }

    public void setNomeExercicio(String nome) {
        this.nomeExercicio.set(nome);
    }

    public String getExercicioEnviado() {
		return exercicioEnviado.get();
	}

    public void setExercicioEnviado(String exercicioEnviado){
    	this.exercicioEnviado.set(exercicioEnviado);
    }

    public StringProperty exercicioEnviadoProperty() {
		return exercicioEnviado;
	}

    public StringProperty nomeExercicioProperty(){
    	return nomeExercicio;
    }

    public String getNomeArquivo() {
        return nomeArquivo.get();
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo.set(nomeArquivo);
    }

    public StringProperty nomeArquivoProperty(){
    	return nomeArquivo;
    }

}
