/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import sistema.dados.ExercicioDAO;
import sistema.model.Exercicio;

/**
 *
 * @author raiote
 */
public class ExercicioServico {

    ExercicioDAO exercicioDAO;

    public ExercicioServico() {
        exercicioDAO = new ExercicioDAO();
    }

    public Exercicio cadastrarExercicio(String descricaoExercicio, String codigoProva) {
        if (exercicioDAO.pesquisar(descricaoExercicio, codigoProva) == null) {
            Exercicio retorno = exercicioDAO.gravarExercicio(descricaoExercicio, codigoProva);
            if (retorno.getCodigo() != null) {
                return retorno;
            }
        }
        return null;
    }

    public Exercicio pesquisarPorCodigo(String codigoExercicio) {
        return exercicioDAO.pesquisarPorCodigo(codigoExercicio);

    }

    public Exercicio pesquisarPorProva(String codigoProva) {
        return exercicioDAO.pesquisarPorProva(codigoProva);
    }

    public void removerExercicio(Exercicio exercicio) {
        if (exercicioDAO.pesquisarPorCodigo(exercicio.getCodigo()) != null) {
            exercicioDAO.remover(exercicio);
        }
    }

    public void atualizarExercicio(Exercicio exercicio) {
        if (exercicioDAO.pesquisarPorCodigo(exercicio.getCodigo()) != null) {
            exercicioDAO.atualizarExercicio(exercicio);
        }
    }
}
