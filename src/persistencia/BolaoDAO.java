package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

import prova3.*;

public class BolaoDAO {

	private Bolao bolao;
	
	
	public void inserirNome() {
		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into bolao (participante) values (?)");
			inserir.setString(1, bolao.getPainelNome().getTextFieldNome().getText());
			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSelecoesQuartas() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set selQF1=?, selQF2=?, selQF3=?, selQF4=?, selQF5=?, selQF6=?, selQF7=?, selQF8=? where participante=?");
			up.setString(1, bolao.getPainelQuartas().getPainelPlacar1().getSelecao1());
			up.setString(2, bolao.getPainelQuartas().getPainelPlacar1().getSelecao2());
			up.setString(3, bolao.getPainelQuartas().getPainelPlacar2().getSelecao1());
			up.setString(4, bolao.getPainelQuartas().getPainelPlacar2().getSelecao2());
			up.setString(5, bolao.getPainelQuartas().getPainelPlacar3().getSelecao1());
			up.setString(6, bolao.getPainelQuartas().getPainelPlacar3().getSelecao2());
			up.setString(7, bolao.getPainelQuartas().getPainelPlacar4().getSelecao1());
			up.setString(8, bolao.getPainelQuartas().getPainelPlacar4().getSelecao2());
			up.setString(9, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlacarSelecoesQuartas() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set plcQF1=?, plcQF2=?, plcQF3=?, plcQF4=?, plcQF5=?, plcQF6=?, plcQF7=?, plcQF8=? where participante=?");
			up.setInt(1, bolao.getPainelQuartas().getPainelPlacar1().getPlacarSelecao1());
			up.setInt(2, bolao.getPainelQuartas().getPainelPlacar1().getPlacarSelecao2());
			up.setInt(3, bolao.getPainelQuartas().getPainelPlacar2().getPlacarSelecao1());
			up.setInt(4, bolao.getPainelQuartas().getPainelPlacar2().getPlacarSelecao2());
			up.setInt(5, bolao.getPainelQuartas().getPainelPlacar3().getPlacarSelecao1());
			up.setInt(6, bolao.getPainelQuartas().getPainelPlacar3().getPlacarSelecao2());
			up.setInt(7, bolao.getPainelQuartas().getPainelPlacar4().getPlacarSelecao1());
			up.setInt(8, bolao.getPainelQuartas().getPainelPlacar4().getPlacarSelecao2());
			up.setString(9, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSelecoesSemi() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set selSF1=?, selSF2=?, selSF3=?, selSF4=? where participante=?");
			up.setString(1, bolao.getPainelSemi().getPainelPlacar1().getSelecao1());
			up.setString(2, bolao.getPainelSemi().getPainelPlacar1().getSelecao2());
			up.setString(3, bolao.getPainelSemi().getPainelPlacar2().getSelecao1());
			up.setString(4, bolao.getPainelSemi().getPainelPlacar2().getSelecao2());
			up.setString(5, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlacarSelecoesSemi() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set plcSF1=?, plcSF2=?, plcSF3=?, plcSF4=? where participante=?");
			up.setInt(1, bolao.getPainelSemi().getPainelPlacar1().getPlacarSelecao1());
			up.setInt(2, bolao.getPainelSemi().getPainelPlacar1().getPlacarSelecao2());
			up.setInt(3, bolao.getPainelSemi().getPainelPlacar2().getPlacarSelecao1());
			up.setInt(4, bolao.getPainelSemi().getPainelPlacar2().getPlacarSelecao2());
			up.setString(5, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSelecoesFinal() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set selFN1=?, selFN2=?, campeao=? where participante=?");
			up.setString(1, bolao.getPainelFinal().getPainelPlacar1().getSelecao1());
			up.setString(2, bolao.getPainelFinal().getPainelPlacar1().getSelecao2());
			up.setString(3, bolao.getPainelFinal().getPainelPlacar1().getGanhador());
			up.setString(4, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlacarSelecoesFinal() {

		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set plcFN1=?, plcFN2=? where participante=?");
			up.setInt(1, bolao.getPainelFinal().getPainelPlacar1().getPlacarSelecao1());
			up.setInt(2, bolao.getPainelFinal().getPainelPlacar1().getPlacarSelecao2());
			up.setString(3, bolao.getPainelNome().getTextFieldNome().getText());

			up.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
	
	
}
