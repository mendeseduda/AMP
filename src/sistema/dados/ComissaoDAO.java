/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sistema.model.Comissao;

/**
 *
 * @author raiote
 */
public class ComissaoDAO {

    Connection conexao;

    public void cadastrarComissao(Comissao comissao) {
        if (!VerificarDAO.validarCadastro(comissao)) {
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

    public boolean logarComissao(Comissao login) {
        try {
            return VerificarDAO.validarLogin(login);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<Comissao> listarComissao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Comissao> listarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
