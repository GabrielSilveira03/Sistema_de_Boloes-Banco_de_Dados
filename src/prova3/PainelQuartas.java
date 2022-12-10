package prova3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import persistencia.BolaoDAO;
import persistencia.Conexao;

public class PainelQuartas extends JPanel{

	private PainelPlacar painelPlacar1;
	private PainelPlacar painelPlacar2;
	private PainelPlacar painelPlacar3;
	private PainelPlacar painelPlacar4;
	private JPanel painelPlacares;
	private JPanel painelBotao;
	private Janela janelaQuartas;
	private Bolao bolao = new Bolao();
	private BolaoDAO bolaoDAO = new BolaoDAO();
	
	public PainelQuartas(PainelNome painelNome) {
		setBolao(painelNome.getBolao());
		setBolaoDAO(painelNome.getBolaoDAO());
		
		criarPainelPlacares();
		criarPainelBotao();
		
		setPreferredSize(new Dimension(600,600));
		setLayout(new BorderLayout());
		add(new JLabel(qtdTraco() + "Quartas de Final:" + qtdTraco()), BorderLayout.NORTH);
		add(painelPlacares, BorderLayout.CENTER);
		add(painelBotao, BorderLayout.SOUTH);
	}
	
	public String qtdTraco() {
		String traco = "-------------------------------------------------------------";
		
		return traco;
	}
	
	public void criarPainelPlacares() {
		painelPlacar1 = criarPainelPlacar();
		painelPlacar2 = criarPainelPlacar();
		painelPlacar3 = criarPainelPlacar();
		painelPlacar4 = criarPainelPlacar();
		
		JPanel painelPlacares = new JPanel();
		painelPlacares.setPreferredSize(new Dimension(600,400));
		painelPlacares.setLayout(new GridLayout(4,1));
		painelPlacares.add(painelPlacar1);
		painelPlacares.add(painelPlacar2);
		painelPlacares.add(painelPlacar3);
		painelPlacares.add(painelPlacar4);
		
		this.painelPlacares = painelPlacares;
	}
	
	public PainelPlacar criarPainelPlacar() {
		PainelPlacar painelPlacar = new PainelPlacar();
		
		return painelPlacar;
	}
	
	public void criarPainelBotao() {
		JPanel painelBotao = new JPanel();
		painelBotao.setLayout(new GridLayout(2,1));
		painelBotao.add(new JLabel(""));
		painelBotao.add(criarBotao(this));
		
		this.painelBotao = painelBotao;
	}
	
	public JButton criarBotao(PainelQuartas painelQuartas) {
		JButton botao = new JButton();
		botao.setText("Enviar");
		botao.setPreferredSize(new Dimension(600,50));
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bolao.setPainelQuartas(painelQuartas);
				bolaoDAO.setBolao(bolao);
				updateBancoDados();
				janelaQuartas.dispose();
				Janela janelaSemi = new Janela(painelQuartas);
			}
		});
		
		return botao;
	}
	
	public void carregarGanhadores() {
		painelPlacar1.determinarGanhador();
		painelPlacar2.determinarGanhador();
		painelPlacar3.determinarGanhador();
		painelPlacar4.determinarGanhador();
	}
	
	public void updateBancoDados() {
		carregarGanhadores();
		bolaoDAO.updateSelecoesQuartas();
		bolaoDAO.updatePlacarSelecoesQuartas();
		
	}
	
	public PainelPlacar getPainelPlacar1() {
		return painelPlacar1;
	}
	
	public PainelPlacar getPainelPlacar2() {
		return painelPlacar2;
	}
	
	public PainelPlacar getPainelPlacar3() {
		return painelPlacar3;
	}
	
	public PainelPlacar getPainelPlacar4() {
		return painelPlacar4;
	}
	
	public BolaoDAO getBolaoDAO() {
		return bolaoDAO;
	}
	
	public Bolao getBolao() {
		return bolao;
	}
	
	public void setJanelaQuartas(Janela janelaQuartas) {
		this.janelaQuartas = janelaQuartas;
	}
	
	public void setBolaoDAO(BolaoDAO bolaoDao) {
		this.bolaoDAO = bolaoDAO;
	}
	
	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
	
}
