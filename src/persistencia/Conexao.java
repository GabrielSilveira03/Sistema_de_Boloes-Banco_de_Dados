package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String host;
	private String usuario;
	private String senha;
	private String banco;
	
	public Conexao() {

		this.host = "localhost";
		this.banco = "boloes_copa";
		this.usuario = "root";
		this.senha = "";
	}
	
	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
		}
		return null;
	}
}
