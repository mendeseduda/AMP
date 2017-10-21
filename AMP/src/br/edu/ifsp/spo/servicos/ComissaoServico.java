package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.dados.ComissaoDAO;
import br.edu.ifsp.spo.model.Comissao;

public class ComissaoServico implements ComissaoServicoInterface {

    @Override
    public void cadastrar(int id, String userName, String senha) {
        try {
            new ComissaoDAO().cadastrarComissao(new Comissao(id, userName, senha));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean logar(Comissao comissao) {
        try {
            return new ComissaoDAO().logarComissao(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comissao> listarComissao() {
        return new ComissaoDAO().listarComissao();
    }

    @Override
    public List<Comissao> listarPorId(int id) {
        return new ComissaoDAO().listarPorId(id);
    }

    @Override
    public void atualizarComissao(Comissao comissao) {
        try {
            new ComissaoDAO().atualizarComissao(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void deletarComissao(Comissao comissao) {
        try {
            new ComissaoDAO().deletarComissao(comissao.getIdComissao());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
