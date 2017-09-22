package sistema.dados;

import java.util.List;
import sistema.model.Grupo;

public interface GrupoDAOInterface {
    public void cadastrarGrupo(Grupo grupo);
    public List<Grupo> listarGrupos();
    public List<Grupo> listarPorId(int idGrupo);
    public void atualizarGrupo(Grupo grupo);
    public void deletarGrupo(int idGrupo);
    
}
