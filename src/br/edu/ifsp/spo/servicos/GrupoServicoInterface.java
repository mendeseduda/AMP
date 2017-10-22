package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Tutor;

public interface GrupoServicoInterface {

    public Grupo cadastrar(String userName, String senha, Tutor tutor);

    public boolean logar(Grupo grupo);

    public void atualizarGrupo(Grupo grupo);

    public void deletarGrupo(Grupo grupo);

    public List<Grupo> listarGrupos();

    public List<Grupo> listarPorId(int id);

}
