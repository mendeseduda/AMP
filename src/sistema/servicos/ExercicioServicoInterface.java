/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import sistema.model.Exercicio;

/**
 *
 * @author Eduardo
 */
public interface ExercicioServicoInterface {
    
    public Exercicio cadastrarExercicio(String descricaoExercicio, String codigoProva);
    
    public Exercicio pesquisarPorCodigo(String codigoExercicio);
    
    public Exercicio pesquisarPorProva(String codigoProva);
    
    public void removerExercicio(Exercicio exercicio);
    
    public void atualizarExercicio(Exercicio exercicio);
    
}
