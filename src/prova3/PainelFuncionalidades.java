package prova3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import persistencia.BolaoDAO;

public class PainelFuncionalidades extends JPanel{

	private Janela janelaFuncionalidades;
	private Bolao bolao;
	private BolaoDAO bolaoDAO;
	
	public PainelFuncionalidades() {
		bolao = new Bolao();
		bolaoDAO = new BolaoDAO();
		
		setPreferredSize(new Dimension(400,300));
		setLayout(new BorderLayout());
		add(new JLabel("--------------------------------Funcionalidades Bolao--------------------------------"), BorderLayout.NORTH);
		add(criarPainelBotoes(), BorderLayout.SOUTH);
		
	}
	
	public JPanel criarPainelBotoes() {
		JPanel painelBotoes = new JPanel();
		painelBotoes.setPreferredSize(new Dimension(400,200));
		painelBotoes.setLayout(new GridLayout(4,1));
		painelBotoes.add(criarCadastrar(this));
		painelBotoes.add(criarMostrar());
		painelBotoes.add(criarImportar());
		painelBotoes.add(criarExportar());
		
		return painelBotoes;
	}
	
	public JButton criarCadastrar(PainelFuncionalidades painelFuncionalidades) {
		JButton botao = new JButton();
		botao.setPreferredSize(new Dimension(400,100));
		botao.setText("Cadastrar Novo Bolao");
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Janela janelaNome = new Janela(painelFuncionalidades);
			}
		});
		
		return botao;
	}
	
	public JButton criarMostrar() {
		JButton botao = new JButton();
		botao.setPreferredSize(new Dimension(400,100));
		botao.setText("Mostrar Boloes Cadastrados");
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return botao;
	}
	
	public JButton criarImportar() {
		JButton botao = new JButton();
		botao.setPreferredSize(new Dimension(400,100));
		botao.setText("Importar Boloes");
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return botao;
	}
	
	public JButton criarExportar() {
		JButton botao = new JButton();
		botao.setPreferredSize(new Dimension(400,100));
		botao.setText("Exportar Boloes");
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		return botao;
	}
	
	public BolaoDAO getBolaoDAO() {
		return bolaoDAO;
	}
	
	public Bolao getBolao() {
		return bolao;
	}
}
