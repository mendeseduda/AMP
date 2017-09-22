package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.model.Grupo;

public class GrupoDAO implements GrupoDAOInterface {

    private static Connection conexao;

    @Override
    public void cadastrarGrupo(Grupo grupo) {
        if (!VerificarDAO.validarCadastro(grupo)) {
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Grupo VALUES(?,?);";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1,grupo.getIdGrupo());
                ps.setInt(2,grupo.getTutor().getIdTutor());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conexao.fechar(conexao);
        }
    }

    public static boolean logarGrupo(Grupo login) {
        try {
            return VerificarDAO.validarLogin(login);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Grupo> listarGrupos() {
       List<Grupo> gruposEncontrados = new ArrayList<>();
		conexao = Conexao.abrir(); 
		String sql = "SELECT * FROM Grupo;";
		
		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Grupo grupo = new Grupo(rs.getInt("Codigo_Grupo"), rs.getString("userName"), null);
				gruposEncontrados.add(grupo);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		Conexao.fechar(conexao);
		return gruposEncontrados;
	}

    @Override
    public List<Grupo> listarPorId(int idGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarGrupo(Grupo grupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarGrupo(int idGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
