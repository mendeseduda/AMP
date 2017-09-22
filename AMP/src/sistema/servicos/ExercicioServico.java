package sistema.servicos;

import java.util.List;
import sistema.dados.ExercicioDAO;
import sistema.model.Exercicio;
import sistema.model.Prova;

public class ExercicioServico implements ExercicioServicoInterface{

    @Override
    public void cadastrarExercicio(int id, String nome, String nomeArquivo, Prova prova) {
        try {
            new ExercicioDAO().inserirExercicio(new Exercicio(id, nome, nomeArquivo, prova));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Exercicio> listarPorCodigo(int codigoExercicio) {
        return new ExercicioDAO().pesquisarPorCodigo(codigoExercicio);
    }

    @Override
    public List<Exercicio> listarExercicios(int codigoProva) {
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
