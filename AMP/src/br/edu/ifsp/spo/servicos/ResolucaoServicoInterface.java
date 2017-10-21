/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.spo.servicos;

import br.edu.ifsp.spo.model.Resolucao;

/**
 *
 * @author Eduardo
 */
public interface ResolucaoServicoInterface {

    public void cadastrarResolucao(Resolucao resolucao);

    public Resolucao pesquisarPorCodigo(String codigoResolucao);

    public void removerResolucao(Resolucao resolucao);

    public void atualizarResolucao(Resolucao resolucao);
}
