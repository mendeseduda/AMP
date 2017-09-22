
package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.model.Comissao;

public class ComissaoDAO implements ComissaoDAOInterface{

    static Connection conexao;

    @Override
    public  void cadastrarComissao(Comissao comissao) {
        if (!VerificarDAO.validarCadastro(comissao)) {
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Comissao VALUES(?);";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1,comissao.getIdComissao());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conexao.fechar(conexao);
        }
    }

    @Override
    public boolean logarComissao(Comissao login) {
        try {
            return VerificarDAO.validarLogin(login);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public List<Comissao> listarComissao() {
       List<Comissao> comissariosEncontrados = new ArrayList<>();
		conexao = Conexao.abrir(); 
		String sql = "SELECT * FROM Comissao;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Comissao comissao = new Comissao(rs.getInt("Codigo_Comissao"), rs.getString("userName"), null);
				comissariosEncontrados.add(comissao);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		Conexao.fechar(conexao);
		return comissariosEncontrados;
	}

    @Override
    public List<Comissao> listarPorId(int idComissao) {
        	List<Comissao> comissariosEncontrados = new ArrayList<>();
		conexao = Conexao.abrir();
		String sql = "SELECT * FROM Comissao WHERE Codigo_Comissao LIKE ?;";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,"%" + idComissao+ "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Comissao comissario = new Comissao(rs.getInt("Codigo_Comissario"), rs.getString("userName"), null);
				comissariosEncontrados.add(comissario);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		Conexao.fechar(conexao);
		return comissariosEncontrados;
	}

    @Override
    public void atualizarComissao(Comissao comissao) {
      conexao = Conexao.abrir();
        String sql = "UPDATE Comissao SET userName = ?, senha = ? WHERE Codigo_Comissao = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, comissao.getUserName());
            ps.setString(2, comissao.getSenha());
            ps.setInt(3, comissao.getIdComissao());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        Conexao.fechar(conexao);
    }

    @Override
    public void deletarComissao(int idComissao) {
        conexao = Conexao.abrir();
        String sql = "DELETE Comissao FROM Comissao WHERE Codigo_Comissao = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idComissao);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}

    

    
    

