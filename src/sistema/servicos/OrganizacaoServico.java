package sistema.servicos;

import java.util.List;
import sistema.model.Organizacao;

public class OrganizacaoServico implements OrganizacaoServicoInterface {
    
    @Override
    public void cadastrarOrganizacao(int id, String userName, String senha) {
        try {
            new OrganizacaoDAO().cadastrarOrganizacao(new Organizacao(id, userName, senha));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    @Override
    public boolean logar(Organizacao organizacao){
        try {
            return new OrganizacaoDAO().logarOrganizacao(organizacao);
        } catch (Exception e) {
        }
    }
    
    @Override
    public void atualizarOrganizacao(Organizacao organizacao) {
        try {
            new OrganizacaoDAO().cadastrarOrganizacao(organizacao);
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
            return new OrganizacaoDAO().listarOrganizacoes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Organizacao> listarPorId(int id){
        try {
            return new OrganizacaoDAO().listarPorID(id);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
