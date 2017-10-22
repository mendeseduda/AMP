package br.edu.ifsp.spo.dados;

import java.util.List;

import br.edu.ifsp.spo.model.Organizacao;

public interface OrganizacaoDAOInterface {

    public void cadastrarOrganizador(Organizacao organizacao);

    public boolean logarOrganizador(Organizacao organizacao);

    public List<Organizacao> listarOrganizadores();

    public List<Organizacao> listarPorId(int idOrganizacao);

    public void atualizarOrganizacao(Organizacao organizacao);

    public void deletarOrganizacao(int idOrganizacao);
}
