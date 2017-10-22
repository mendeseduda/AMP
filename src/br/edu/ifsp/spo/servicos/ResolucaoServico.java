/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.spo.servicos;

import br.edu.ifsp.spo.dados.ResolucaoDAO;
import br.edu.ifsp.spo.model.Resolucao;

/**
 *
 * @author aluno
 */
public class ResolucaoServico implements ResolucaoServicoInterface{

	private ResolucaoDAO resolucaoDAO;

	public ResolucaoServico() {
		resolucaoDAO = new ResolucaoDAO();
	}

	@Override
	public void inserirResolucao(Resolucao resolucao) {
		try {
			resolucaoDAO.gravarResolucao(resolucao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Resolucao pesquisarPorCodigo(String codigoResolucao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerResolucao(Resolucao resolucao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarResolucao(Resolucao resolucao) {
		// TODO Auto-generated method stub

	}

}
