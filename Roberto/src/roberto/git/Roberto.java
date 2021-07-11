package roberto;

// Este programa simula o funcionamento de uma calculadora num�rica.

//S�o importados diversos layouts, dimens�es, pain�is, bordas, etc.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CalculadoraGui extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JTextField display;
	
	//S�o inclu�dos os bot�es do teclado, sendo a numera��o de 0 a 9, soma, subtra��o, divis�o, multiplica��o, pot�ncia, ligar.
	
	private String[] txtBotoesTeclado = new String[] { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "0",
			"^", "C", "CE", "OFF" };
	
	//Inclu�do o bot�o de desligar.
	
	public CalculadoraGui() {
		this.setTitle("Calculadora");
		
		//A dimens�o da calculadora.
		
		this.setSize(new Dimension(249, 328));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		this.getRootPane().setBorder(new EmptyBorder(5, 5, 5, 5));

		display = new JTextField();
		display.setPreferredSize(new Dimension(200, 40));
		this.add(display, BorderLayout.PAGE_START);

		JPanel panelTeclado = new JPanel(new GridLayout(4, 4));
		
		//Para string, exatamente ao que for teclado.
		
		for (String string : txtBotoesTeclado) {
			JButton btn = new JButton(string);
			panelTeclado.add(btn);

			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JButton o = (JButton) evt.getSource();
					adicionaNoDisplay(o.getText());
				}
			});
		}

		add(panelTeclado, BorderLayout.CENTER);

		JPanel rodaPePanel = new JPanel();
		rodaPePanel.setLayout(null);
		JButton btnCalcular = new JButton("Calcular");
		rodaPePanel.add(btnCalcular);
		rodaPePanel.setPreferredSize(new Dimension(100, 30));
		btnCalcular.setBounds(5,5,100,25);
		
		add(rodaPePanel, BorderLayout.PAGE_END);
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				//O resultado � o que foi executado nos c�lculos.
				
				String resultado = executaCalculo(display.getText());
				display.setText(resultado);
			}
		});

	protected String executaCalculo(String text) {
		return "calcular";
	}

	protected void adicionaNoDisplay(String text) {
		if(text==null)
			return;
		
		if(text.contains("C")) {
			display.setText("");
			return;
		}
		display.setText(display.getText() + text);
	}
	
	//Programa praticamente pronto, agora restam os testes e implementa��es.
	
	public static void main(String[] args) {
		CalculadoraGui exemplo = new CalculadoraGui();
		exemplo.setVisible(true);
	}