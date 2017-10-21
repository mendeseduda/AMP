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
public class ResolucaoServico {
    ResolucaoDAO resolucaoDAO;

    public ResolucaoServico(){
        resolucaoDAO = new ResolucaoDAO();
    }

    public void cadastrarResolucao(Resolucao resolucao) {
        if(resolucaoDAO.pesquisarPorCodigo(resolucao.getCodigoResolucao())==null){
            resolucaoDAO.gravarResolucao(resolucao);
        }
    }

    public Resolucao pesquisarPorCodigo(String codigoResolucao){
        return resolucaoDAO.pesquisarPorCodigo(codigoResolucao);

    }

    public void removerResolucao(Resolucao resolucao){
        if(resolucaoDAO.pesquisarPorCodigo(resolucao.getCodigoResolucao()) != null){
            resolucaoDAO.remover(resolucao);
        }
    }

    public void atualizarResolucao(Resolucao resolucao){
        if(resolucaoDAO.pesquisarPorCodigo(resolucao.getCodigoResolucao())!=null){
            resolucaoDAO.atualizarResolucao(resolucao);
        }
    }
}
