package sistema.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.model.Exercicio;
import sistema.model.Prova;

public class ProvaDAO implements ProvaDAOInterface {

    private Connection conexao;
    
    @Override
   public Prova inserirProva(Prova prova) {
        if (!VerificarDAO.validarProva(prova)) {
                conexao = Conexao.abrir();
                String sql = "INSERT INTO Prova VALUES(?,?,?);";
            try {
                InputStream file = new FileInputStream(prova.getCadernoProva());
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1,prova.getIdProva());
                ps.setString(2,prova.getNomeProva());
                ps.setBlob(3,file);
                ps.executeUpdate();
            } catch (FileNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            }
    

    @Override
    public List<Prova> listarProvas() {
        
    }

    @Override
    public List<Prova> listarPorId(int idProva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarProva(Prova prova) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarProva(int idProva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   
    
}
