/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.spo.model;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Roberto Bolgheroni
 */
public class Resolucao {

	private int idResolucao;
	private Exercicio exercicio; // exercicio ao qual se propoe a resolver
	private Grupo grupo; // grupo desenvolvedor
	private String resolucao; // texto da resolucao - codigo - em si
	private boolean Avaliado;
	private int pontuacao;

	public Resolucao(Exercicio exercicio, Grupo grupo) {
		this.exercicio = exercicio;
		this.grupo = grupo;
	}

	public int getIdResolucao() {
		return idResolucao;
	}

	public void setIdResolucao(int idResolucao) {
		this.idResolucao = idResolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public String getResolucao() {
		return resolucao;
	}
}
