package br.edu.ifsp.spo.dados;

import java.util.List;

import br.edu.ifsp.spo.model.Grupo;

public interface GrupoDAOInterface {
	public void cadastrarGrupo(Grupo grupo);

	public boolean logarGrupo(Grupo grupo);

	public List<Grupo> listarGrupos();

	public List<Grupo> listarPorId(int idGrupo);

	public void atualizarGrupo(Grupo grupo);

	public void deletarGrupo(int idGrupo);

}
