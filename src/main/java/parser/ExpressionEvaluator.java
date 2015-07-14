package parser;

import java.io.StringReader;

import java_cup.runtime.Symbol;
import syntechtics.jxpression.functions.Function;

public class ExpressionEvaluator {

	public static Object evaluate(String expression) throws Exception {
		return evaluate(expression, null);
	}
	
	public static Object evaluate(String expression, Object object) throws Exception {
		parser p = new parser(new Scanner(new StringReader(expression)));
		p.setObject(object);
		Symbol symbol=p.parse();
		Function function = p.result;
		return function.evaluate();
	}
}
