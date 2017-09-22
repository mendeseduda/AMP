/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.servicos;

import java.io.File;
import java.util.List;
import sistema.dados.ProvaDAO;
import sistema.model.Prova;

/**
 *
 * @author raiote
 */
public class ProvaServico {

    public void cadastrarProva(int id, String nomeProva, File file) {
        try {
            new ProvaDAO().inserirProva(new Prova(id, nomeProva, file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarProva(Prova prova) {
        try {
            new ProvaDAO().atualizarProva(prova);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarProva(Prova prova) {
        try {
            new ProvaDAO().deletarProva(prova.getIdProva());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisarPorCodigo(int idProva) {
        try {
            return new ProvaDAO().listarPorId(idProva);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prova> listarProva() {
        try {
            return new ProvaDAO().ListarProvas();
        } catch (Exception e) {
        throw  new RuntimeException(e);
        }
    }

}
