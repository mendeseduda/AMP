/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import java.util.List;
import sistema.dados.ComissaoDAO;
import sistema.model.Comissao;

/**
 *
 * @author Roberto Bolgheroni
 */
public class ComissaoServico implements ComissaoServicoInterface {

    @Override
    public void cadastrar(int id, String userName, String senha) {
        try {
            new ComissaoDAO().cadastrarComissao(new Comissao(id, userName, senha));
        } catch (Exception e) {
        }
    }

    public boolean Logar(Comissao comissao) {
        try {
            return new ComissaoDAO().logarComissao(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comissao> listarComissao() {
        return new ComissaoDAO().listarComissao();
    }

    public List<Comissao> listarPorId(int id) {
        return new ComissaoDAO().listarPorId(id);
    }

    public void atualizarComissao(Comissao comissao) {
        try {
            new ComissaoDAO().atualizarComissao(comissao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarComissao(Comissao comissao) {
        try {
            new ComissaoDAO().deletarComissao(comissao.getIdComissao());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
