/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import java.util.List;
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

    public List<Exercicio> listarPorCodigo(int codigoExercicio) {
        return new ExercicioDAO().pesquisarPorCodigo(codigoExercicio);
    }

    public List<Exercicio> listarExercicios(int codigoProva) {
        return new ExercicioDAO().pesquisarExercicios();
    }

    public void removerExercicio(Exercicio exercicio) {
        try {
            new ExercicioDAO().remover(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarExercicio(Exercicio exercicio) {
        try {
            new ExercicioDAO().atualizarExercicio(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
