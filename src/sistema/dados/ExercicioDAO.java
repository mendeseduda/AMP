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
import java.sql.Statement;
import sistema.model.Exercicio;
import sistema.model.Prova;

/**
 *
 * @author raiote
 */
public class ExercicioDAO {

    Connection conexao;

    public void inserirExercicio(Exercicio exercicio) {

        if (VerificarDAO.validarExercicio(exercicio)) {
            try {
                int id = 0;
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Exercicio VALUES(DEFAULT, ?, ?)";
                PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, exercicio.getNome());
                ps.setString(2, exercicio.getProva().getCodigoProva());
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Exercicio pesquisarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizarExercicio(Exercicio exercicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remover(Exercicio exercicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Exercicio pesquisarPorProva(String codigoProva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
