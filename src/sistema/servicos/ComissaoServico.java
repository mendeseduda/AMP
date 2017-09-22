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
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

/**
 *
 * @author Roberto Bolgheroni
 */
public class ComissaoServico implements ComissaoServicoInterface {

    @Override
    public void cadastrar(int id, String userName, String senha) {
        try {
            new ComissaoDAO().cadastrarComissao(new Comissao(id, userName, senha));
        } catch (Exception e) {
        }
    }

    public boolean Logar(Comissao comissao) {
        try {
            return new ComissaoDAO().logarComissao(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comissao> listarComissao() {
        return new ComissaoDAO().listarComissao();
    }

    public List<Comissao> listarPorId(int id) {
        return new ComissaoDAO().listarPorId(id);
    }

    public void atualizarComissao(Comissao comissao) {
        try {
            new ComissaoDAO().atualizarComissao(comissao);
        } catch (Exception e) {
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

        for (Avaliacao avaliacao : new AvaliacaoDAO().listarPorComissao(comissao)) {
            resolucoesAvaliadas.add(avaliacao.getResolucao());
        }
        return resolucoesAvaliadas;
    }

}
