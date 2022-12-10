package prova3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelPlacar extends JPanel {

	private JPanel painelLabel;
	private JPanel painelInserir;
	private String ganhador;
	private JTextField selecao1;
	private JTextField selecao2;
	private JTextField placarSelecao1;
	private JTextField placarSelecao2;
	
	public PainelPlacar() {
		painelLabel = criarPainelLabel();
		painelInserir = criarPainelInserir();
		
		setPreferredSize(new Dimension(600,100));
		setLayout(new GridLayout(2,1));
		add(painelLabel);
		add(painelInserir);
	}
	
	public JPanel criarPainelLabel() {
		JPanel painelLabel = new JPanel();
		painelLabel.setLayout(new GridLayout(1,5));
		painelLabel.add(criarLabelSelecao());
		painelLabel.add(criarLabelPlacar());
		painelLabel.add(new JLabel(""));
		painelLabel.add(criarLabelPlacar());
		painelLabel.add(criarLabelSelecao());
		
		return painelLabel;
	}
	
	public JLabel criarLabelSelecao() {
		JLabel label = new JLabel("Selecao:");
		label.setPreferredSize(new Dimension(50,25));
		
		return label;
	}
	
	public JLabel criarLabelPlacar() {
		JLabel label = new JLabel("Placar:");
		label.setPreferredSize(new Dimension(50,25));
		
		return label;
	}
	
	public JPanel criarPainelInserir() {
		selecao1 = criarTextFieldNome();
		selecao2 = criarTextFieldNome();
		placarSelecao1 = criarTextFieldNumero();
		placarSelecao2 = criarTextFieldNumero();
		
		JLabel labelX = new JLabel("                  X");
		labelX.setPreferredSize(new Dimension(50,50));
		
		JPanel painelInserir = new JPanel();
		painelInserir.setLayout(new GridLayout(1,5));
		painelInserir.add(selecao1);
		painelInserir.add(placarSelecao1);
		painelInserir.add(labelX);
		painelInserir.add(placarSelecao2);
		painelInserir.add(selecao2);
		
		return painelInserir;
	}
	
	public JTextField criarTextFieldNome() {
		JTextField texto = new JTextField();
		texto.setPreferredSize(new Dimension(50,25));
		
		return texto;
	}
	
	public JTextField criarTextFieldNumero() {
		JTextField texto = new JTextField();
		texto.setPreferredSize(new Dimension(50,25));
		
		return texto;
	}
	
	public void determinarGanhador() {
		if(getPlacarSelecao1() > getPlacarSelecao2()) {
			ganhador = getSelecao1();
		} else if(getPlacarSelecao2()>getPlacarSelecao1()) {
			ganhador = getSelecao2();
		} else {
			Random aleatorio = new Random();
			int num = aleatorio.nextInt(1);
			if(num == 0) {
				ganhador = getSelecao1();
			} else if(num == 1) {
				ganhador = getSelecao2();
			}
		}
	}
	
	public String getSelecao1() {
		return selecao1.getText();
	}
	
	public String getSelecao2() {
		return selecao2.getText();
	}
	
	public int getPlacarSelecao1() {
		int num = Integer.parseInt(placarSelecao1.getText());
		
		return num;
	}
	
	public int getPlacarSelecao2() {
		int num = Integer.parseInt(placarSelecao2.getText());
		
		return num;
	}
	
	public String getGanhador() {
		return ganhador;
	}
	
	public void setSelecao1(String selecao) {
		selecao1.setText(selecao);
	}
	
	public void setSelecao2(String selecao) {
		selecao2.setText(selecao);
	}
}
