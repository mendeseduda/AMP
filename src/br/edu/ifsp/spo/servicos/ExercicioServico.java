package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.dados.ExercicioDAO;
import br.edu.ifsp.spo.model.Exercicio;
import br.edu.ifsp.spo.model.Prova;

public class ExercicioServico implements ExercicioServicoInterface{

    @Override
    public Exercicio cadastrarExercicio(int idExercicio, String nome, String nomeArquivo, Prova prova) {
        try {
        	Exercicio temp = new Exercicio(idExercicio, nome, nomeArquivo, prova);
        	new ExercicioDAO().inserirExercicio(temp);
        	return temp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Exercicio> listarPorCodigo(int codigoExercicio) {
        return new ExercicioDAO().pesquisarPorCodigo(codigoExercicio);
    }

    @Override
    public List<Exercicio> listarExercicios() {
        return new ExercicioDAO().pesquisarExercicios();
    }

    @Override
    public void removerExercicio(Exercicio exercicio) {
        try {
            new ExercicioDAO().remover(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarExercicio(Exercicio exercicio) {
        try {
            new ExercicioDAO().atualizarExercicio(exercicio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
