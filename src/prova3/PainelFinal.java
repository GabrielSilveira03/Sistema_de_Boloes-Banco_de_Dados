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

public class PainelFinal extends JPanel{

	private PainelPlacar painelPlacar1;
	private JPanel painelPlacares;
	private JPanel painelBotao;
	private PainelSemi painelSemi;
	private Janela janelaFinal;
	private Bolao bolao = new Bolao();
	private BolaoDAO bolaoDAO = new BolaoDAO();
	
	public PainelFinal() {
		
	}
	
	public PainelFinal(PainelSemi painelSemi) {
		setBolao(painelSemi.getBolao());
		setBolaoDAO(painelSemi.getBolaoDAO());
		
		this.painelSemi = painelSemi;
		
		criarPainelPlacares();
		criarPainelBotao();
		
		setPreferredSize(new Dimension(600,200));
		setLayout(new BorderLayout());

		add(new JLabel(qtdTraco() + "Final:" + qtdTraco()), BorderLayout.NORTH);
		add(painelPlacares, BorderLayout.CENTER);
		add(painelBotao, BorderLayout.SOUTH);
	}
	
	public String qtdTraco() {
		String traco = "---------------------------------------------------------------------";
		
		return traco;
	}
	
	public void criarPainelPlacares() {
		painelPlacar1 = criarPainelPlacar();
		
		painelPlacar1.setSelecao1(painelSemi.getPainelPlacar1().getGanhador());
		painelPlacar1.setSelecao2(painelSemi.getPainelPlacar2().getGanhador());
		
		JPanel painelPlacares = new JPanel();
		painelPlacares.setPreferredSize(new Dimension(600,100));
		painelPlacares.setLayout(new GridLayout(1,1));
		painelPlacares.add(painelPlacar1);
		
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
	
	public JButton criarBotao(PainelFinal painelFinal) {
		JButton botao = new JButton();
		botao.setText("Enviar");
		botao.setPreferredSize(new Dimension(600,25));
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bolao.setPainelFinal(painelFinal);
				setBolao(painelFinal.getBolao());
				bolaoDAO.setBolao(bolao);
				updateBancoDados();
				janelaFinal.dispose();
				Janela janelaResultado = new Janela(painelFinal);
			}
		});
		
		return botao;
	}
	
	public void carregarGanhadores() {
		painelPlacar1.determinarGanhador();
	}
	
	
	public void updateBancoDados() {
		carregarGanhadores();
		bolaoDAO.updateSelecoesFinal();
		bolaoDAO.updatePlacarSelecoesFinal();
		
	}
	
	public PainelPlacar getPainelPlacar1() {
		return painelPlacar1;
	}
	
	public Bolao getBolao() {
		return bolao;
	}
	
	public void setJanelaFinal(Janela janelaFinal) {
		this.janelaFinal = janelaFinal;
	}
	
	public void setBolaoDAO(BolaoDAO bolaoDao) {
		this.bolaoDAO = bolaoDAO;
	}
	
	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}
}
