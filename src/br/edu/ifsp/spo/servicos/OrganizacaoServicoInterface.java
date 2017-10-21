package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.model.Organizacao;

public interface OrganizacaoServicoInterface {

    public void cadastrarOrganizacao(int id, String userName, String senha);

    public boolean logar(Organizacao organizacao);

    public void atualizarOrganizacao(Organizacao organizacao);

    public void deletarOrganizacao(Organizacao organizacao);

    public List<Organizacao> listarOrganizacao();

    public List<Organizacao> listarPorId(int id);

}
