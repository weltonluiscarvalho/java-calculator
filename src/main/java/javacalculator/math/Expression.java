package javacalculator.math;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Expression {

	public String calculate(String expression) {
		
		expression = expression.trim();
		
		if(Pattern.matches(".*[+\\-]{2}.*", expression)) {
			return "malformed expression";
		}
		
		String[] numbers = expression.split("[+-]");
		
		String[] operators = expression.split("[0-9]+");
		operators = Arrays.stream(operators)
                .filter(sinal -> sinal.equals("+") || sinal.equals("-"))
                .toArray(String[]::new);
		
		if(operators.length != numbers.length - 1) {
			return "malformed expression";
		}
		
		int resultado;
		
		return "XD";
	}

}
