package sistema.servicos;

import java.util.List;
import sistema.dados.GrupoDAO;
import sistema.model.Grupo;
import sistema.model.Tutor;

public class GrupoServico implements GrupoServicoInterface {

    @Override
    public void cadastrar(int id, String userName, String senha, Tutor tutor) {
        try {
            new GrupoDAO().cadastrarGrupo(new Grupo(id, tutor, userName, senha));
        } catch (Exception e) {
        }
    }

    @Override
    public boolean logar(Grupo grupo) {
        try {
            return new GrupoDAO().logarGrupo(grupo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void atualizarGrupo(Grupo grupo) {
        try {
            new GrupoDAO().atualizarGrupo(grupo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void deletarGrupo(Grupo grupo){
        try {
            new GrupoDAO().deletarGrupo(grupo.getIdGrupo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Grupo> listarGrupos() {
        try {
            return new GrupoDAO().listarGrupos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Grupo> listarPorId(int id) {
        try {
            return new GrupoDAO().listarPorId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
