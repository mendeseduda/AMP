package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.dados.OrganizacaoDAO;
import br.edu.ifsp.spo.model.Organizacao;

public class OrganizacaoServico implements OrganizacaoServicoInterface {

    @Override
    public void cadastrarOrganizacao(int id, String userName, String senha) {
        try {
            new OrganizacaoDAO().cadastrarOrganizador(new Organizacao(id, userName, senha));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean logar(Organizacao organizacao) {
        try {
            return new OrganizacaoDAO().logarOrganizador(organizacao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarOrganizacao(Organizacao organizacao) {
        try {
            new OrganizacaoDAO().atualizarOrganizacao(organizacao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletarOrganizacao(Organizacao organizacao) {
        try {
            new OrganizacaoDAO().deletarOrganizacao(organizacao.getIdOrganizacao());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Organizacao> listarOrganizacao() {
        try {
            return new OrganizacaoDAO().listarOrganizadores();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Organizacao> listarPorId(int id) {
        try {
            return new OrganizacaoDAO().listarPorId(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
