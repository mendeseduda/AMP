/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.servicos;

import sistema.apresentacao.Tela;
import sistema.dados.Arquivo;
import sistema.model.Comissao;
import sistema.model.Maratona;
import sistema.model.Resolucao;
import java.util.ArrayList;

/**
 *
 * @author Roberto Bolgheroni
 */ 
public class ComissaoServico implements LoginInterface {
    private Validar validar;
    private Tela tela;
    private Arquivo arquivo;
    
    public ComissaoServico(Arquivo arquivo, Tela tela, Validar validar){
        this.validar = validar;
        this.tela = tela;
        this.arquivo = arquivo;
    }

    public void cadastrar(Comissao comissao){
        if(validar.validarCadastro(comissao)){
            arquivo.gravar(comissao);
        }else{
            tela.exibirErroCadastro(comissao);
        }
    }
    
    public void avaliarResolucao(Comissao comissao, Resolucao resolucao, String pontuacao){
        arquivo.gravar(comissao, resolucao, pontuacao);
    }
    public void listarResolucoesPendentes(Comissao comissao, Maratona maratona){
        // Ler uma string e chamar um metodo da tela pra exibir
        
    }

    @Override
    public void logar(String id, String senha, Maratona maratona) {
        if(/*arquivo.ler(id, senha, maratona) != null,
                ou seja, ha um registro assim na tabela de cadastros da maratona especificada*/true){
            //realiza processos do comissario
        }
    }
}