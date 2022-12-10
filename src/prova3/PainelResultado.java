package prova3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelResultado extends JPanel {

	private ImageIcon bandeira;
	private PainelFinal painelFinal;
	private Janela janelaResultado;
	private String ganhador;
	
	public PainelResultado(PainelFinal painelFinal) {
		this.painelFinal = painelFinal;
		ganhador = painelFinal.getPainelPlacar1().getGanhador();
		
		JLabel label = new JLabel(qtdTraco() + "Selecao Campea segundo o participante:" + qtdTraco());
		label.setPreferredSize(new Dimension(400,100));
		
		setSize(500,400);
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(criarPainelBandeira(), BorderLayout.CENTER);
	}
	
	public String qtdTraco() {
		String traco = "-------------------------------";
		
		return traco;
	}
	
	public JPanel criarPainelBandeira() {
		JPanel painelBandeira = new JPanel();
		painelBandeira.setPreferredSize(new Dimension(450,300));
		verificarBandeira();
		JLabel labelBandeira = new  JLabel(bandeira);
		labelBandeira.setPreferredSize(new Dimension(425,275));
		painelBandeira.add(labelBandeira);
		
		return painelBandeira;
	}
	
	public void verificarBandeira() {		
		if(ganhador.equals("ARG")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/argentina.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("BRA")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/brasil.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("CRO")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/croacia.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("FRA")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/franca.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("ENG")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/inglaterra.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("NED")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/holanda.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("MAR")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/marrocos.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		} else if(ganhador.equals("POR")) {
			bandeira = new ImageIcon(new ImageIcon("src/bandeiras/portugal.jpg").getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
		}
	}
	
	public void setJanelaResultado(Janela janelaResultado) {
		this.janelaResultado = janelaResultado;
	}
}
