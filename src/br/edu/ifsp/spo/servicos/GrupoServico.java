package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.dados.GrupoDAO;
import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Tutor;

public class GrupoServico implements GrupoServicoInterface {

    @Override
    public Grupo cadastrar(String userName, String senha, Tutor tutor) {
        try {
        	Grupo temp = new Grupo(tutor, userName, senha);
            new GrupoDAO().cadastrarGrupo(temp);
            return temp;
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean logar(Grupo grupo) {
    	try {
            return new GrupoDAO().logarGrupo(grupo);
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
            new GrupoDAO().deletarGrupo(grupo.getId());
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
