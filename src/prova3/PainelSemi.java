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

import persistencia.BolaoDAO;
import persistencia.Conexao;

public class PainelSemi extends JPanel{

	private PainelPlacar painelPlacar1;
	private PainelPlacar painelPlacar2;
	private JPanel painelPlacares;
	private JPanel painelBotao;
	private PainelQuartas painelQuartas;
	private Janela janelaSemi;
	private Bolao bolao = new Bolao();
	private BolaoDAO bolaoDAO = new BolaoDAO();
	
	public PainelSemi(PainelQuartas painelQuartas) {
		setBolao(painelQuartas.getBolao());
		setBolaoDAO(painelQuartas.getBolaoDAO());
		
		this.painelQuartas = painelQuartas;
		
		criarPainelPlacares();
		criarPainelBotao();
		
		setPreferredSize(new Dimension(600,400));
		setLayout(new BorderLayout());

		add(new JLabel(qtdTraco() + "Semifinal:" + qtdTraco()), BorderLayout.NORTH);
		add(painelPlacares, BorderLayout.CENTER);
		add(painelBotao, BorderLayout.SOUTH);
	}
	
	public String qtdTraco() {
		String traco = "------------------------------------------------------------------";
		
		return traco;
	}
	
	public void criarPainelPlacares() {
		painelPlacar1 = criarPainelPlacar();
		painelPlacar2 = criarPainelPlacar();
		
		painelPlacar1.setSelecao1(painelQuartas.getPainelPlacar1().getGanhador());
		painelPlacar1.setSelecao2(painelQuartas.getPainelPlacar2().getGanhador());
		painelPlacar2.setSelecao1(painelQuartas.getPainelPlacar3().getGanhador());
		painelPlacar2.setSelecao2(painelQuartas.getPainelPlacar4().getGanhador());
		
		JPanel painelPlacares = new JPanel();
		painelPlacares.setPreferredSize(new Dimension(600,200));
		painelPlacares.setLayout(new GridLayout(2,1));
		painelPlacares.add(painelPlacar1);
		painelPlacares.add(painelPlacar2);
		
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
	
	public JButton criarBotao(PainelSemi painelSemi) {
		JButton botao = new JButton();
		botao.setText("Enviar");
		botao.setPreferredSize(new Dimension(600,50));
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bolao.setPainelSemi(painelSemi);
				bolaoDAO.setBolao(bolao);
				updateBancoDados();
				janelaSemi.dispose();
				Janela janelaFinal = new Janela(painelSemi);
			}
		});
		
		return botao;
	}
	
	public void carregarGanhadores() {
		painelPlacar1.determinarGanhador();
		painelPlacar2.determinarGanhador();
	}
	
	public void updateBancoDados() {
		carregarGanhadores();
		bolaoDAO.updateSelecoesSemi();
		bolaoDAO.updatePlacarSelecoesSemi();
		
	}
	
	public PainelPlacar getPainelPlacar1() {
		return painelPlacar1;
	}
	
	public PainelPlacar getPainelPlacar2() {
		return painelPlacar2;
	}
	
	public Bolao getBolao() {
		return bolao;
	}
	
	public BolaoDAO getBolaoDAO() {
		return bolaoDAO;
	}
	
	public void setJanelaSemi(Janela janelaSemi) {
		this.janelaSemi = janelaSemi;
	}
	
	public void setBolaoDAO(BolaoDAO bolaoDao) {
		this.bolaoDAO = bolaoDAO;
	}
	
	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
	
}
