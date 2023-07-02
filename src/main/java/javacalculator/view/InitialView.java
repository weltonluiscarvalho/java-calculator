package javacalculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InitialView extends JFrame {
	
	private static final long serialVersionUID = -2160020859182948123L;
	JPanel visorPanel;
	JPanel numberButtonPanel;
	JPanel operationButtonPanel;
	
	public InitialView() {
		createPanels();
		createLabel();
		createButtons();
		configFrame();
	}
	
	public void run() {
		setLocationRelativeTo(null); //centralizar no centro da tela ao abrir
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private void configFrame() {
		setTitle("Java Calculator");
		setSize(300, 500);
		setLayout(new BorderLayout());
		
		add(visorPanel, BorderLayout.NORTH);
		add(numberButtonPanel, BorderLayout.CENTER);
		add(operationButtonPanel, BorderLayout.EAST);
	}
	
	private void createLabel() {
		JLabel label = new JLabel("visor");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		Border visorBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		label.setBorder(visorBorder);
		visorPanel.add(label);
	}
	
	private void createButtons() {
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		JButton button0 = new JButton("0");
		JButton buttonDecimalDivisor = new JButton(",");
		JButton buttonPlus = new JButton("+");
		JButton buttonMinus = new JButton("-");
		JButton buttonEqual = new JButton("=");
		
		numberButtonPanel.add(button1);
		numberButtonPanel.add(button2);
		numberButtonPanel.add(button3);
		numberButtonPanel.add(button4);
		numberButtonPanel.add(button5);
		numberButtonPanel.add(button6);
		numberButtonPanel.add(button7);
		numberButtonPanel.add(button8);
		numberButtonPanel.add(button9);
		numberButtonPanel.add(buttonDecimalDivisor);
		numberButtonPanel.add(button0);
		numberButtonPanel.add(buttonEqual);
		
		operationButtonPanel.add(buttonPlus);
		operationButtonPanel.add(buttonMinus);
	}
	
	private void createPanels() {
		visorPanel = new JPanel();
		visorPanel.setLayout(new GridLayout());
		visorPanel.setPreferredSize(new Dimension(300, 100));
		visorPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		numberButtonPanel = new JPanel();
		numberButtonPanel.setPreferredSize(new Dimension(200, 350));
		numberButtonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		numberButtonPanel.setLayout(new GridLayout(4,3,10,10));
		
		operationButtonPanel = new JPanel();
		operationButtonPanel.setPreferredSize(new Dimension(100, 350));
		operationButtonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		operationButtonPanel.setLayout(new GridLayout(2,1,10,10));
	}

}
