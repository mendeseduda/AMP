package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.dados.GrupoDAO;
import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Tutor;

public class GrupoServico implements GrupoServicoInterface {

    @Override
    public void cadastrar(String userName, String senha, Tutor tutor) {
        try {
            new GrupoDAO().cadastrarGrupo(new Grupo(tutor, userName, senha));
        } catch (Exception e) {
        }
    }

    @Override
    public boolean logar(String username, String password) {
    	try {
            return true;//new GrupoDAO().logarGrupo(username, password);
        } catch (Exception e) {
        	e.printStackTrace();
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
