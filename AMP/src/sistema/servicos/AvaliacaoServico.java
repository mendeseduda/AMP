/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.servicos;

import java.util.List;
import sistema.dados.AvaliacaoDAO;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

/**
 *
 * @author aluno
 */
public class AvaliacaoServico {
    private AvaliacaoDAO avaliacaoDAO;
    
    public AvaliacaoServico(){
        avaliacaoDAO = new AvaliacaoDAO();
    }
    
    public List<Avaliacao> listarPorComissao(Comissao comissao){
        return avaliacaoDAO.listarPorComissao(comissao);
    } 
    public List<Avaliacao> listarPorResolucao(Resolucao resolucao){
        return avaliacaoDAO.listarPorResolucao(resolucao);
    } 
    
    public void adicionarAvaliacao(Avaliacao avaliacao){
        if(null == avaliacaoDAO.pesquisarAvaliacao(avaliacao.getResolucao().getCodigoResolucao(), avaliacao.getAvaliador_Resolucao().getUserName())){
            avaliacaoDAO.gravarAvaliacao(avaliacao);
        }
    }
    
    public void atualizarAvaliacao(Avaliacao avaliacao){
        if(null == avaliacaoDAO.pesquisarAvaliacao(avaliacao.getResolucao().getCodigoResolucao(), avaliacao.getAvaliador_Resolucao().getUserName())){
            avaliacaoDAO.atualizarAvaliacao(avaliacao);
        }
    }
}
