package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Tutor;

public interface GrupoServicoInterface {

    public void cadastrar(String userName, String password, Tutor tutor);

    public boolean logar(String username, String password);

    public void atualizarGrupo(Grupo grupo);

    public void deletarGrupo(Grupo grupo);

    public List<Grupo> listarGrupos();

    public List<Grupo> listarPorId(int id);

}
