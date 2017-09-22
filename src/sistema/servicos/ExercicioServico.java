/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import sistema.dados.ExercicioDAO;
import sistema.model.Exercicio;
import sistema.model.Prova;

/**
 *
 * @author raiote
 */
public class ExercicioServico {

    public void cadastrarExercicio(int id, String nome, String nomeArquivo, Prova prova) {
        try {
            new ExercicioDAO().inserirExercicio(new Exercicio(id, nome, nomeArquivo, prova));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Exercicio pesquisarPorCodigo(String codigoExercicio) {
        return new ExercicioDAO().pesquisarPorCodigo(codigoExercicio);

    }

    public Exercicio pesquisarPorProva(String codigoProva) {
        return new ExercicioDAO().pesquisarPorProva(codigoProva);
    }

    public void removerExercicio(Exercicio exercicio) {
        if (new ExercicioDAO().pesquisarPorCodigo(exercicio.getIdExercicio()) != 1) {
            new ExercicioDAO().remover(exercicio);
        }
    }

    public void atualizarExercicio(Exercicio exercicio) {
        if (new ExercicioDAO().pesquisarPorCodigo(exercicio.getIdExercicio()) != 1) {
            new ExercicioDAO().atualizarExercicio(exercicio);
        }
    }
}
