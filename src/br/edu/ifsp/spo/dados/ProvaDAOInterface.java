package br.edu.ifsp.spo.dados;

import java.util.List;

import br.edu.ifsp.spo.model.Prova;

public interface ProvaDAOInterface {

    public void inserirProva(Prova prova);

    public List<Prova> listarProvas();

    public List<Prova> listarPorId(int idProva);

    public void atualizarProva(Prova prova);

    public void deletarProva(int idProva);

}
