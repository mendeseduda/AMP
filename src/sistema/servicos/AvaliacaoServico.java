package sistema.servicos;

import java.util.List;
import sistema.dados.AvaliacaoDAO;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

/**
 *
 * @author aluno
 */
public class AvaliacaoServico implements AvaliacaoServicoInterface {

    @Override
    public List<Avaliacao> listarPorComissao(Comissao comissao) {
        return new AvaliacaoDAO().listarPorComissao(comissao);
    }

    @Override
    public List<Avaliacao> listarPorResolucao(Resolucao resolucao) {
        return new AvaliacaoDAO().listarPorResolucao(resolucao);
    }

    @Override
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (null == new AvaliacaoDAO().pesquisarAvaliacao(avaliacao.getResolucao().getCodigoResolucao(), avaliacao.getAvaliador_Resolucao().getUserName())) {
            new AvaliacaoDAO().gravarAvaliacao(avaliacao);
        }
    }

    @Override
    public void atualizarAvaliacao(Avaliacao avaliacao) {
        if (null == new AvaliacaoDAO().pesquisarAvaliacao(avaliacao.getResolucao().getCodigoResolucao(), avaliacao.getAvaliador_Resolucao().getUserName())) {
            new AvaliacaoDAO().atualizarAvaliacao(avaliacao);
        }
    }
}
