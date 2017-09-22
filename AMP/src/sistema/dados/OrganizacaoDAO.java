package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.model.Organizacao;

public class OrganizacaoDAO implements OrganizacaoDAOInterface {

    private Connection conexao;
    
    @Override
    public void cadastrarOrganizador(Organizacao organizacao) {
       if (!VerificarDAO.validarCadastro(organizacao)) {
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Grupo VALUES(?,?,?);";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1,organizacao.getIdOrganizacao());
                ps.setString(2,organizacao.getUserName());
                ps.setString(3,organizacao.getSenha());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conexao.fechar(conexao);
        }
    }

    @Override
    public boolean logarOrganizador(Organizacao organizacao) {
        try {
            return VerificarDAO.validarLogin(organizacao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Organizacao> listarOrganizadores() {
        List<Organizacao> organizadoresEncontrados = new ArrayList<>();
		conexao = Conexao.abrir(); 
		String sql = "SELECT * FROM Comissao;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Organizacao organizacao = new Organizacao(rs.getInt("Codigo_Organizador"), rs.getString("userName"), null);
				organizadoresEncontrados.add(organizacao);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		Conexao.fechar(conexao);
		return organizadoresEncontrados;
	}

    @Override
    public List<Organizacao> listarPorId(int idOrganizacao) {
        List<Organizacao> organizadoresEncontrados = new ArrayList<>();
		conexao = Conexao.abrir();
		String sql = "SELECT * FROM Organizacao WHERE Codigo_Organizacao LIKE ?;";
		try{
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1,"%" + idOrganizacao+ "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Organizacao organizacao = new Organizacao(rs.getInt("Codigo_Organizador"), rs.getString("userName"), null);
				organizadoresEncontrados.add(organizacao);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		Conexao.fechar(conexao);
		return organizadoresEncontrados;
	}

    @Override
    public void atualizarOrganizacao(Organizacao organizacao) {
     if (!VerificarDAO.validarCadastro(organizacao)) {
             conexao = Conexao.abrir();
        String sql = "UPDATE Organizacao SET userName = ?, senha = ? WHERE Codigo_Organizador = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, organizacao.getUserName());
            ps.setString(2, organizacao.getSenha());
            ps.setInt(3, organizacao.getIdOrganizacao());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexao.fechar(conexao);
    }
        }

    @Override
    public void deletarOrganizacao(int idOrganizacao) {
      conexao = Conexao.abrir();
        String sql = "DELETE Organizacao FROM Organizacao WHERE Codigo_Organizador = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idOrganizacao);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   
    
}
