package sistema.servicos;

import java.io.File;
import java.util.List;
import sistema.dados.ProvaDAO;
import sistema.model.Prova;

public class ProvaServico implements ProvaServicoInterface{
    
    @Override
    public void cadastrarProva(int id, String nomeProva, File file) {
        try {
            new ProvaDAO().inserirProva(new Prova(id, nomeProva, file));
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
