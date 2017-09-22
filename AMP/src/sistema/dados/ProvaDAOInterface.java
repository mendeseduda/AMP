package sistema.dados;


import java.util.List;
import sistema.model.Prova;

public interface ProvaDAOInterface {
    public Prova inserirProva(Prova prova);
    public List<Prova> listarProvas();
    public List<Prova> listarPorId(int idProva);
    public void atualizarProva(Prova prova);
    public void deletarProva(int idProva);
    
}
