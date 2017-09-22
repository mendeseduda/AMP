package sistema.servicos;

import java.io.File;
import java.util.List;
import sistema.model.Prova;

public interface ProvaServicoInterface {
    
    public void cadastrarProva(int id, String nomeProva, File file);
    
    public void atualizarProva(Prova prova);
    
    public void deletarProva(Prova prova);
    
    public List<Prova> pesquisarPorCodigo(int idProva);
    
    public List<Prova> listarProva();
}
