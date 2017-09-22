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
import sistema.model.Exercicio;
;
import sistema.model.Logavel;

/**
 *
 * @author aluno
 */


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
            String sql = "SELECT Nome_Exercicio FROM Exercicio WHERE Nome_Exercicio = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, exercicio.getNome());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
