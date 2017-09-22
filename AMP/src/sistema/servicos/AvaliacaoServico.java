/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.servicos;

import sistema.dados.AvaliacaoDAO;
import sistema.model.Avaliacao;

/**
 *
 * @author aluno
 */
public class AvaliacaoServico {
    private AvaliacaoDAO avaliacaoDAO;
    
    public AvaliacaoServico(){
        avaliacaoDAO = new AvaliacaoDAO();
    }
    
    public void adicionarAvaliacao(Avaliacao avaliacao){
        if(avaliacaoDAO.pesquisarAvaliacao(avaliacao)){
            avaliacaoDAO.gravarAvaliacao(avaliacao);
        }
    }
}
