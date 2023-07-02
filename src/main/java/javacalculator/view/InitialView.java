package javacalculator.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InitialView extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -2160020859182948123L;
	private JPanel visorPanel;
	private JPanel numberButtonPanel;
	private JPanel operationButtonPanel;
	private JLabel label;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button0;
	private JButton buttonDecimalDivisor;
	private JButton buttonPlus;
	private JButton buttonMinus;
	private JButton buttonEqual;
	private JButton buttonDelete;
	
	public InitialView() {
		createPanels();
		createLabel();
		createButtons();
		associateListeners();
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
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		Border visorBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		label.setBorder(visorBorder);
		visorPanel.add(label);
	}
	
	private void createButtons() {
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button0 = new JButton("0");
		buttonDecimalDivisor = new JButton(",");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonEqual = new JButton("=");
		buttonDelete = new JButton("DEL");
		
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
		
		operationButtonPanel.add(buttonDelete);
		operationButtonPanel.add(buttonPlus);
		operationButtonPanel.add(buttonMinus);
	}
	
	private void associateListeners() {
		for (Component component : numberButtonPanel.getComponents()) {
			JButton button = (JButton) component;
			button.addActionListener(this);
		}
		
		for (Component component : operationButtonPanel.getComponents()) {
			JButton button = (JButton) component;
			button.addActionListener(this);
		}
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
		operationButtonPanel.setLayout(new GridLayout(3,1,10,10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			label.setText(label.getText() + button1.getText());
		}
		
		if(e.getSource() == button2) {
			label.setText(label.getText() + button2.getText());
		}
		if(e.getSource() == button3) {
			label.setText(label.getText() + button3.getText());
		}
		if(e.getSource() == button4) {
			label.setText(label.getText() + button4.getText());
		}
		if(e.getSource() == button5) {
			label.setText(label.getText() + button5.getText());
		}
		if(e.getSource() == button6) {
			label.setText(label.getText() + button6.getText());
		}
		if(e.getSource() == button7) {
			label.setText(label.getText() + button7.getText());
		}
		if(e.getSource() == button8) {
			label.setText(label.getText() + button8.getText());
		}
		if(e.getSource() == button9) {
			label.setText(label.getText() + button9.getText());
		}
		if(e.getSource() == button0) {
			label.setText(label.getText() + button0.getText());
		}
//		if(e.getSource() == buttonDecimalDivisor) {
//			if(!label.getText().contains(",")) {
//				label.setText(label.getText() + buttonDecimalDivisor.getText());
//			}
//		}
		if (e.getSource() == buttonDelete) {
		    String currentText = label.getText();
		    if (currentText.length() > 0) {
		        label.setText(currentText.substring(0, currentText.length() - 1));
		    }
		}
		if (e.getSource() == buttonPlus) {
			if(!label.getText().contains(buttonMinus.getText())) {
				label.setText(label.getText() + buttonPlus.getText());
			}
		}
		if (e.getSource() == buttonMinus) {
			if(!label.getText().contains(buttonPlus.getText())) {
				label.setText(label.getText() + buttonMinus.getText());
			}
		}
		if (e.getSource() == buttonEqual) {
			if(label.getText().charAt(0) != '+' && label.getText().charAt(0) != '-' && 
					label.getText().charAt(label.getText().length() - 1) != '+' && 
					label.getText().charAt(label.getText().length() - 1) != '-') {
				
				String[] numbers;
				Boolean plusOperation = label.getText().contains(buttonPlus.getText());
				Boolean minusOperation = label.getText().contains(buttonMinus.getText());
				
				if(!plusOperation && !minusOperation) {
					return;
				}
				
				if(plusOperation) {
					numbers = label.getText().split("\\+");
					
					Integer result = 0;
					
					for(int i = 0; i < numbers.length; i++) {
						result += Integer.valueOf(numbers[i]);
					}
					
					label.setText(result.toString());
				} 
				
				if (minusOperation) {
					numbers = label.getText().split("\\-");
					
					Integer result = Integer.valueOf(numbers[0]);
					
					for(int i = 1; i < numbers.length; i++) {
						result -= Integer.valueOf(numbers[i]);
					}
					
					label.setText(result.toString());
				}	
							
			}
		}
	}

}
