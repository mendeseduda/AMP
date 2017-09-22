package sistema.dados;

import java.util.List;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

public interface AvaliacaoDAOInterface {
    public List<Avaliacao> listarPorComissao(Comissao comissao);
    public Avaliacao pesquisarAvaliacao(String codigo_resolucao, String codigo_comissao);
    public  void gravarAvaliacao(Avaliacao avaliacao);
    public  List<Avaliacao> listarPorResolucao(Resolucao resolucao);
    public  void atualizarAvaliacao(Avaliacao avaliacao); 
    
    
}
