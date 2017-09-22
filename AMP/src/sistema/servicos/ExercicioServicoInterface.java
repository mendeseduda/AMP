package sistema.servicos;

import java.util.List;
import sistema.model.Exercicio;
import sistema.model.Prova;

public interface ExercicioServicoInterface {

    public void cadastrarExercicio(int id, String nome, String nomeArquivo, Prova prova);

    public List<Exercicio> listarPorCodigo(int codigoExercicio);

    public List<Exercicio> listarExercicios(int codigoProva);

    public void removerExercicio(Exercicio exercicio);

    public void atualizarExercicio(Exercicio exercicio);

}
