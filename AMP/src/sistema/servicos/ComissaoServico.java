/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import java.util.ArrayList;
import java.util.List;
import sistema.dados.AvaliacaoDAO;
import sistema.dados.ComissaoDAO;
import sistema.dados.ResolucaoDAO;
import sistema.dados.VerificarDAO;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

/**
 *
 * @author Roberto Bolgheroni
 */
public class ComissaoServico {

    private ComissaoDAO comissaoDAO;

    public void cadastrar(Comissao comissao) {
        if (!VerificarDAO.validarCadastro(comissao)) {
            comissaoDAO.gravarComissao(comissao);
        }
    }

    public boolean Logar(Comissao comissao) {
        try {
            return VerificarDAO.validarPassword(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Comissao>listarComissao(){
        return comissaoDAO.listarComissao();
    }
    public List<Comissao>listarPorUsername(String username){
        return comissaoDAO.listarPorUsername(username);
    }

    public void atualizarComissao(Comissao comissao) {
        if (VerificarDAO.validarCadastro(comissao)) {
            comissaoDAO.atualizarComissao(comissao);
        }
    }

    public List<Resolucao> listarResolucoesPendentes(Comissao comissao) {
        ResolucaoDAO resolucaoDAO = new ResolucaoDAO();
        List<Resolucao> resolucoesPendentes = new ArrayList<>();
        List<Resolucao> resolucoesAvaliadas = listarResolucoesAvaliadas(comissao);

        //pra cada resolucao da lista total de resolucoes
        for (Resolucao resolucao : resolucaoDAO.listarResolucoes()) {
            //se a lista de resolucoes avaliadas pelo comissario definido nao conter a resolucao atual
            if (!resolucoesAvaliadas.contains(resolucao)) {
                //a lista de resolucoes pendentes recebe esta resolucao atual
                resolucoesPendentes.add(resolucao);
            }
        }
        //retorna a lista de resolucoes pendentes a serem avaliadas pelo comissario especifico
        return resolucoesPendentes;

    }

    public List<Resolucao> listarResolucoesAvaliadas(Comissao comissao) {
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
        List<Resolucao> resolucoesAvaliadas = new ArrayList<>();

        for (Avaliacao avaliacao : avaliacaoDAO.listarPorComissao(comissao)) {
            resolucoesAvaliadas.add(avaliacao.getResolucao());
        }
        return resolucoesAvaliadas;
    }

}
