package sistema.dados;

import java.util.List;
import sistema.model.Exercicio;

public interface ExercicioDAOInterface {
    public void inserirExercicio(Exercicio exercicio);
    public void atualizarExercicio(Exercicio exercicio);
    public void remover(Exercicio exercicio);
    public List<Exercicio> pesquisarPorCodigo(int codigo);
    public List<Exercicio> pesquisarExercicios();
    
}
