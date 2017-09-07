package DataBaseConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExerciseData {

	private static Connection conn;

	public static void insertFile(File arq) {
		conn = ConnectionData.abrir();

		try {
			InputStream file = new FileInputStream(arq);

			PreparedStatement ps = ConnectionData.abrir().prepareStatement("INSERT INTO Resolucao VALUES (?)");
			ps.setBlob(1, file);
			ps.executeUpdate();
			file.close();
			ps.close();
			ConnectionData.fechar(conn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void getFiles() {
		conn = ConnectionData.abrir();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT resolucaoFile FROM Resolucao");

			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				System.out.println("-");
				String text = rs.getString(1);
				String className = text.split("public class ", 2)[1].split("[\\W]")[0];
				System.out.println(className);
				FileWriter gravador = new FileWriter("resources/exercises/" + className + ".java");
				PrintWriter gravar = new PrintWriter(gravador);
				gravar.print(rs.getString(1));
				gravador.close();
				gravar.close();
			}
			rs.close();
			st.close();
			ConnectionData.fechar(conn);
		} catch (Exception e) {
			//TODO: Lidar com um arquivo que não seja .java
		}

	}
}
