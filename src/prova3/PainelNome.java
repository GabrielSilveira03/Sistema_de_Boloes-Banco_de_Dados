package prova3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.BolaoDAO;
import persistencia.Conexao;

public class PainelNome extends JPanel{

	private JPanel painelCima;
	private JPanel painelBaixo;
	private JTextField nome;
	private Janela janelaNome;
	private Bolao bolao = new Bolao();
	private BolaoDAO bolaoDAO = new BolaoDAO();
	
	public PainelNome(PainelFuncionalidades painelFuncionalidades) {
		setBolao(painelFuncionalidades.getBolao());
		setBolaoDAO(painelFuncionalidades.getBolaoDAO());
		
		criarPainelCima();
		criarPainelBaixo();
		setPreferredSize(new Dimension(400,200));
		setLayout(new BorderLayout());
		add(painelCima, BorderLayout.NORTH);
		add(painelBaixo, BorderLayout.CENTER);
		
	}
	
	public void criarPainelCima() {
		JPanel painelCima = new JPanel();
		painelCima.setPreferredSize(new Dimension(400,50));
		painelCima.add(new JLabel("----------------------Infomacao do participante do Bolao:----------------------"));
		
		this.painelCima = painelCima;
	}
	
	public void criarPainelBaixo() {
	JPanel painelBaixo = new JPanel();
	nome = new JTextField();
	
	painelBaixo.setPreferredSize(new Dimension(400,150));
	painelBaixo.setLayout(new GridLayout(2,2));
	painelBaixo.add(new JLabel("Nome:"));
	painelBaixo.add(nome);
	painelBaixo.add(new JLabel(""));
	painelBaixo.add(criarEnviar(this));

	this.painelBaixo = painelBaixo;
	}
	
	public JButton criarEnviar(PainelNome painelNome) {
		JButton botao = new JButton();
		botao.setText("Enviar");
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bolao.setPainelNome(painelNome);
				bolaoDAO.setBolao(bolao);
				bolaoDAO.inserirNome();
				janelaNome.dispose();
				Janela janelaQuartas = new Janela(painelNome);
			}
		});
		
		return botao;
	}
	
	public JTextField getTextFieldNome() {
		return nome;
	}
	
	public BolaoDAO getBolaoDAO() {
		return bolaoDAO;
	}
	
	public Bolao getBolao() {
		return bolao;
	}
	
	public void setJanelaNome(Janela janelaNome) {
		this.janelaNome = janelaNome;
	}
	
	public void setBolaoDAO(BolaoDAO bolaoDao) {
		this.bolaoDAO = bolaoDAO;
	}
	
	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
}
