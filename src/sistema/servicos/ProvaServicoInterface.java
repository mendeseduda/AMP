/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import java.util.ArrayList;
import sistema.model.Exercicio;
import sistema.model.Prova;

/**
 *
 * @author Eduardo
 */
public interface ProvaServicoInterface {
    public Prova cadastrarProva(String descricaoProva);
    
    public Prova pesquisarPorCodigo(String codigoProva);
    
    public ArrayList<Exercicio> listarExercicios(Prova prova);
}
