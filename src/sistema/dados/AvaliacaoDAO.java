/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.model.Avaliacao;
import sistema.model.Comissao;
import sistema.model.Resolucao;

public class AvaliacaoDAO implements AvaliacaoDAOInterface {

   private Connection conexao;
    
    @Override
    public List<Avaliacao> listarPorComissao(Comissao comissao) {
       List<Avaliacao> comissariosEncontrados = new ArrayList<>();
		conexao = Conexao.abrir();
		String sql = "SELECT * FROM Avaliacao WHERE Codigo_Resolucao LIKE ?;";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,"%" + comissao.getIdComissao() + "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Avaliacao avaliacao = new Avaliacao
				comissariosEncontrados.add(avaliacao);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		Conexao.fechar(conexao);
		return comissariosEncontrados;
	}

    @Override
    public Avaliacao pesquisarAvaliacao(String codigo_resolucao, String codigo_comissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gravarAvaliacao(Avaliacao avaliacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Avaliacao> listarPorResolucao(Resolucao resolucao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarAvaliacao(Avaliacao avaliacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
