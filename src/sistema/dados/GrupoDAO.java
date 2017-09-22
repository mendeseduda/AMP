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
import sistema.model.Grupo;

/**
 *
 * @author aluno
 */
public class GrupoDAO {

    private static Connection conexao;

    public static void cadastrarGrupo(Grupo grupo) {
        if (!VerificarDAO.validarCadastro(grupo)) {
            try {
                conexao = Conexao.abrir();
                String sql = ""; //TODO: Adicionar statement PEPE - Insert
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static boolean logarGrupo(Grupo login) {
        try {
            return VerificarDAO.validarLogin(login);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
