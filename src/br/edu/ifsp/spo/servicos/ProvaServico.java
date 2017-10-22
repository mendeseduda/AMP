package br.edu.ifsp.spo.servicos;

import java.io.File;
import java.util.List;

import br.edu.ifsp.spo.dados.ProvaDAO;
import br.edu.ifsp.spo.model.Prova;

public class ProvaServico implements ProvaServicoInterface{

    @Override
    public Prova cadastrarProva(int id, String nomeProva, File file) {
        try {
            Prova temp = new Prova(id, nomeProva, file);
            new ProvaDAO().inserirProva(temp);
            return temp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarProva(Prova prova) {
        try {
            new ProvaDAO().atualizarProva(prova);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletarProva(Prova prova) {
        try {
            new ProvaDAO().deletarProva(prova.getIdProva());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Prova> pesquisarPorCodigo(int idProva) {
        try {
            return new ProvaDAO().listarPorId(idProva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Prova> listarProva() {
        try {
            return new ProvaDAO().listarProvas();
        } catch (Exception e) {
        throw  new RuntimeException(e);
        }
    }

}
