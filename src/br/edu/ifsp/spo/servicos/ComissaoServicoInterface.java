package br.edu.ifsp.spo.servicos;

import java.util.List;

import br.edu.ifsp.spo.model.Comissao;

public interface ComissaoServicoInterface {

    public void cadastrar(int id, String userName, String senha);

    public boolean logar(Comissao comissao);

    public List<Comissao> listarComissao();

    public List<Comissao> listarPorId(int id);

    public void atualizarComissao(Comissao comissao);

    public void deletarComissao(Comissao comissao);
}
