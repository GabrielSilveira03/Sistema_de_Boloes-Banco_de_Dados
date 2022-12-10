package prova3;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {
	//painel funcionalidades 
	public Janela() {
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	public void addPainel(JPanel painel) {
		add(painel);
		setVisible(true);
	}
	
	//painel nome
	public Janela(PainelFuncionalidades painelFuncoes) {
		PainelNome painelNome = new PainelNome(painelFuncoes);
		setSize(400,200);
		add(painelNome);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		painelNome.setJanelaNome(this);
	}
	
	//painel quartas
	public Janela(PainelNome painelNome) {
		PainelQuartas painelQuartas = new PainelQuartas(painelNome);
		setSize(600,600);
		add(painelQuartas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		painelQuartas.setJanelaQuartas(this);
	}
	
	//painel semi
	public Janela(PainelQuartas painelQuartas) {
		PainelSemi painelSemi = new PainelSemi(painelQuartas);
		
		setSize(600,400);
		add(painelSemi);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		painelSemi.setJanelaSemi(this);
	}
	
	//painel final
	public Janela(PainelSemi painelSemi) {
		PainelFinal painelFinal = new PainelFinal(painelSemi);
		setSize(600,200);
		add(painelFinal);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		painelFinal.setJanelaFinal(this);
	}
	
	//painel resultado
	public Janela(PainelFinal painelFinal) {
		PainelResultado painelResultado = new PainelResultado(painelFinal);
		setSize(500,400);
		add(painelResultado);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		painelResultado.setJanelaResultado(this);
	}
	
}
