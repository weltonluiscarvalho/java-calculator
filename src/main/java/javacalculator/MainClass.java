package javacalculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainClass {

	public static void main(String[] args) {
		
		JLabel label = new JLabel("visor");
		Border visorBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		label.setBorder(visorBorder);
		
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
		
		JPanel visorPanel = new JPanel();
		visorPanel.setBounds(0, 0, 300, 100);
		visorPanel.setBorder(visorBorder);
		
		JPanel numberButtonPanel = new JPanel();
		numberButtonPanel.setBounds(0, 100, 200, 350);
		numberButtonPanel.setLayout(new GridLayout(4,3,10,10));
		
		JPanel operationButtonPanel = new JPanel();
		operationButtonPanel.setBounds(200, 100, 100, 350);
		operationButtonPanel.setLayout(new GridLayout(2,1,10,10));
		
		visorPanel.add(label);
		
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
		
		JFrame frame = new JFrame();
		
		frame.add(visorPanel);
		frame.add(numberButtonPanel);
		frame.add(operationButtonPanel);
		
		frame.setTitle("Java Calculator");
		frame.setSize(300, 500);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null); //centralizar no centro da tela ao abrir
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
