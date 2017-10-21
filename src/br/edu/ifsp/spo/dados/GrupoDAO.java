package br.edu.ifsp.spo.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.spo.model.Grupo;
import br.edu.ifsp.spo.model.Tutor;

public class GrupoDAO implements GrupoDAOInterface {

    private Connection conexao;

    @Override
    public void cadastrarGrupo(Grupo grupo) {
        if (!VerificarDAO.validarCadastro(grupo)) {
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Grupo VALUES(?,?,?,?);";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1,grupo.getIdGrupo());
                ps.setInt(2,grupo.getTutor().getIdTutor());
                ps.setString(3,grupo.getUserName());
                ps.setString(4,grupo.getSenha());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            Conexao.fechar(conexao);
        }
    }

    public boolean logarGrupo(String username, String password) {
        try {
            return VerificarDAO.validarLogin(new Grupo(null, username, password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Grupo> listarGrupos() {
       List<Grupo> gruposEncontrados = new ArrayList<>();
		conexao = Conexao.abrir();
		String sql = "SELECT * FROM Grupo INNER JOIN Tutor ON Grupo.Codigo_Tutor = Tutor.Codigo_Tutor;";

		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Grupo grupo = new Grupo(new Tutor(rs.getInt("Codigo_Tutor"),rs.getString("userName"),null), rs.getString("userName"), null);
				gruposEncontrados.add(grupo);

			}

		}catch(SQLException e){
			throw new RuntimeException(e);
		}

		Conexao.fechar(conexao);
		return gruposEncontrados;
	}

    @Override
    public List<Grupo> listarPorId(int idGrupo) {
        List<Grupo> gruposEncontrados = new ArrayList<>();
		conexao = Conexao.abrir();
		String sql = "SELECT * FROM Grupo INNER JOIN Tutor ON Grupo.Codigo_Tutor = Tutor.Codigo_Tutor WHERE Grupo.Codigo_Grupo LIKE (?);";

		try{
			PreparedStatement ps = conexao.prepareStatement(sql);
                        ps.setString(1,"%" + idGrupo + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Grupo grupo = new Grupo(new Tutor(rs.getInt("Codigo_Tutor"),rs.getString("userName"),null), rs.getString("userName"), null);
				gruposEncontrados.add(grupo);

			}

		}catch(SQLException e){
			throw new RuntimeException(e);
		}

		Conexao.fechar(conexao);
		return gruposEncontrados;
	}

    @Override
    public void atualizarGrupo(Grupo grupo) {
        if (!VerificarDAO.validarCadastro(grupo)) {
             conexao = Conexao.abrir();
        String sql = "UPDATE Grupo SET Codigo_Tutor = ?, userName = ?, senha = ?WHERE Codigo_Grupo = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, grupo.getTutor().getIdTutor());
            ps.setString(2, grupo.getUserName());
            ps.setString(3, grupo.getSenha());
            ps.setInt(4, grupo.getIdGrupo());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Conexao.fechar(conexao);
    }
        }


    @Override
    public void deletarGrupo(int idGrupo) {
       conexao = Conexao.abrir();
        String sql = "DELETE Grupo FROM Grupo WHERE Codigo_Grupo = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idGrupo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
