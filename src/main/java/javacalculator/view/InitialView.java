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

import javacalculator.math.Expression;

public class InitialView extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -2160020859182948123L;
	private JPanel visorPanel;
	private JPanel numberButtonPanel;
	private JPanel operationButtonPanel;
	private JLabel label;
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
		//associateListeners(operationButtonPanel.getComponents());
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
		
		for(int i = 1; i <= 9; i++) {
			numberButtonPanel.add(new JButton(String.valueOf(i)));
		}
		
		buttonDecimalDivisor = new JButton(",");
		button0 = new JButton("0");
		buttonEqual = new JButton("=");
		
		numberButtonPanel.add(buttonDecimalDivisor);
		numberButtonPanel.add(button0);
		numberButtonPanel.add(buttonEqual);
		
		buttonDelete = new JButton("DEL");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		
		operationButtonPanel.add(buttonDelete);
		operationButtonPanel.add(buttonPlus);
		operationButtonPanel.add(buttonMinus);
	}
	
	private void associateListeners() {
		for (Component component : numberButtonPanel.getComponents()) {
			JButton button = (JButton) component;
			if(Character.isDigit(button.getText().charAt(0))) {
				button.addActionListener(e -> label.setText(label.getText() + button.getText()));
			} else if(button.getText() == "=") {
				Expression expression = new Expression();
				button.addActionListener(e -> label.setText(expression.calculate(label.getText())));
			}
		}
		
		for (Component component : operationButtonPanel.getComponents()) {
			JButton button = (JButton) component;
			if(button.getText().length() == 1) {
				button.addActionListener(e -> label.setText(label.getText() + button.getText()));
			} else {
				button.addActionListener(e -> label.setText(""));
			}
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
