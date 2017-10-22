/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsp.spo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.edu.ifsp.spo.model.Resolucao;

/**
 *
 * @author aluno
 */
public class ResolucaoDAO {

	private Connection conexao;

	public void gravarResolucao(Resolucao resolucao) throws IOException {
		conexao = Conexao.abrir();
		String sql = "INSERT INTO Resolucao VALUES (DEFAULT, ?, ?, ?)";
		try {
			FileOutputStream arq = new FileOutputStream(resolucao.getExercicio().getNomeArquivo());
			arq.write(resolucao.getResolucao().getBytes());
			File f = new File(resolucao.getExercicio().getNomeArquivo());
			InputStream file = new FileInputStream(f);

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, resolucao.getGrupo().getId());
			ps.setInt(2, resolucao.getExercicio().getIdExercicio());
			ps.setBlob(3, file);
			ps.executeUpdate();

		} catch (FileNotFoundException | SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

    public List<Resolucao> listarResolucoes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Resolucao pesquisarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void remover(Resolucao resolucao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void atualizarResolucao(Resolucao resolucao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
