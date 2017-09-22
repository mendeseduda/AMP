package sistema.dados;

import java.util.List;
import sistema.model.Organizacao;

public interface OrganizacaoDAOInterface {

    public void cadastrarOrganizador(Organizacao organizacao);
    
    public boolean logarOrganizador(Organizacao organizacao);
    
    public List<Organizacao> listarOrganizadores();

    public List<Organizacao> listarPorId(int idOrganizacao);

    public void atualizarOrganizacao(Organizacao organizacao);

    public void deletarOrganizacao(int idOrganizacao);
}
