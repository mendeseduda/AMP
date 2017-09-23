package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistema.model.Exercicio;

import sistema.model.Logavel;
import sistema.model.Prova;

public class VerificarDAO {

    static Connection conexao;

    public static boolean validarCadastro(Logavel login) {
        try {
            conexao = Conexao.abrir();
            String sql = "SELECT username FROM " + login.toString() + " WHERE ? = username";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login.getUserName());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean validarLogin(Logavel login) {
        try {
            conexao = Conexao.abrir();
            String sql = "SELECT username FROM " + login.toString() + " WHERE ? = username AND ? = password";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login.getUserName());
            ps.setString(2, login.getSenha());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static boolean validarExercicio(Exercicio exercicio) {
        try {
            conexao = Conexao.abrir();
            String sql = "SELECT Nome_Exercicio FROM Exercicio WHERE Nome_Exercicio = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, exercicio.getNome());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validarProva(Prova prova) {
        try {
            conexao = Conexao.abrir();
            String sql = "SELECT Codigo_Prova FROM Prova WHERE Codigo_Prova = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Integer.toString(prova.getIdProva()));
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
