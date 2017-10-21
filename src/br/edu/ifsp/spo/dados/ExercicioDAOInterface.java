package br.edu.ifsp.spo.dados;

import java.util.List;

import br.edu.ifsp.spo.model.Exercicio;

public interface ExercicioDAOInterface {

    public void inserirExercicio(Exercicio exercicio);

    public void atualizarExercicio(Exercicio exercicio);

    public void remover(Exercicio exercicio);

    public List<Exercicio> pesquisarPorCodigo(int codigo);

    public List<Exercicio> pesquisarExercicios();

}
