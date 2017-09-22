package sistema.servicos;

import java.util.List;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

/**
 *
 * @author Eduardo
 */
public interface AvaliacaoServicoInterface {
    
    public List<Avaliacao> listarPorComissao(Comissao comissao);
    
    public List<Avaliacao> listarPorResolucao(Resolucao resolucao);
    
    public void adicionarAvaliacao(Avaliacao avaliacao);
    
    public void atualizarAvaliacao(Avaliacao avaliacao);
}
