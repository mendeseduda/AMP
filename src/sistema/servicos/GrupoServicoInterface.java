package sistema.servicos;

import java.util.List;
import sistema.model.Grupo;
import sistema.model.Tutor;

public interface GrupoServicoInterface {

    public void cadastrar(int id, String userName, String password, Tutor tutor);

    public boolean logar(Grupo grupo);

    public void atualizarGrupo(Grupo grupo);

    public void deletarGrupo(Grupo grupo);

    public List<Grupo> listarGrupos();

    public List<Grupo> listarPorId(int id);

}
