package br.edu.ifsp.spo.model;

import java.time.LocalDateTime;
import java.time.Month;

public class Maratona {

	private LocalDateTime hora_Inicio;
	private LocalDateTime hora_Fim;
	private Prova prova;

	public Maratona(Prova prova) {
		hora_Inicio = LocalDateTime.of(2017, Month.OCTOBER, 23, 8, 30);
		hora_Fim = LocalDateTime.of(2017, Month.OCTOBER, 23, 10, 00);
		this.prova = prova;
	}

	public LocalDateTime getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(LocalDateTime hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public LocalDateTime getHora_Fim() {
		return hora_Fim;
	}

	public void setHora_Fim(LocalDateTime hora_Fim) {
		this.hora_Fim = hora_Fim;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

}
