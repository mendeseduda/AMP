package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.model.Exercicio;
import br.edu.ifsp.spo.model.Prova;

public interface ExercicioServicoInterface {

    public void cadastrarExercicio(int id, String nome, String nomeArquivo, Prova prova);

    public List<Exercicio> listarPorCodigo(int codigoExercicio);

    public List<Exercicio> listarExercicios();

    public void removerExercicio(Exercicio exercicio);

    public void atualizarExercicio(Exercicio exercicio);

}
