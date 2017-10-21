package br.edu.ifsp.spo.dados;

import java.util.List;

import br.edu.ifsp.spo.model.Comissao;

public interface ComissaoDAOInterface {
    public void cadastrarComissao(Comissao comissao);
    public boolean logarComissao(Comissao login);
    public List<Comissao> listarComissao();
    public List<Comissao> listarPorId(int idComissao);
    public void atualizarComissao(Comissao comissao);
    public void deletarComissao(int idComissao);
}
