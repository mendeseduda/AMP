package sistema.dados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
        }
        Conexao.fechar(conexao);
        return prova;
   }
    @Override
    public List<Prova> listarProvas() {
        List<Prova> provasEncontradas = new ArrayList<>();
		conexao = Conexao.abrir(); 
		String sql = "SELECT * FROM Prova";
		try{	
                    PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Prova prova = new Prova(rs.getInt("Codigo_Prova"), rs.getString("Nome_Prova"), null);
				provasEncontradas.add(prova);
				
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		Conexao.fechar(conexao);
		return provasEncontradas;
	}
    

    @Override
    public List<Prova> listarPorId(int idProva) {
        List<Prova> provasEncontradas = new ArrayList<>();
		conexao = Conexao.abrir(); 
		String sql = "SELECT * FROM Prova WHERE Codigo_Prova = ?";
		try{	
                    PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,"%" + idProva + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Prova prova = new Prova(rs.getInt("Codigo_Prova"), rs.getString("Nome_Prova"), null);
				provasEncontradas.add(prova);
				
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		Conexao.fechar(conexao);
		return provasEncontradas;
	}
    

    @Override
    public void atualizarProva(Prova prova) {
       if (!VerificarDAO.validarProva(prova)) {
             conexao = Conexao.abrir();
        String sql = "UPDATE Prova SET Nome_Prova = ?, Caderno_Prova = ? WHERE Codigo_Prova = ?";

        try {
            InputStream file = new FileInputStream(prova.getCadernoProva());
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, prova.getNomeProva());
            ps.setBlob(2, file);
            ps.setInt(3, prova.getIdProva());
            
            ps.executeUpdate();

        } catch (FileNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        Conexao.fechar(conexao);
    }
        }

    @Override
    public void deletarProva(int idProva) {
        conexao = Conexao.abrir();
        String sql = "DELETE Prova FROM Prova WHERE Codigo_Prova = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idProva);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

   
    
}
